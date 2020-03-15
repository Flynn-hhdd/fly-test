package com.example.config;

import javafx.scene.control.Pagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public abstract class BaseDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;
    
    @Autowired
    public JdbcTemplate sqliteTemplate;
    
    @Autowired
    public NamedParameterJdbcTemplate sqliteNamedParameterJdbcTemplate;
    
    @Autowired
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    @Autowired
    public DataSourceTransactionManager transactionManager;
    
    private Logger logger = LoggerFactory.getLogger(BaseDao.class);
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public Pagination JdbcTemplateUniversalPaging(final String sql,
                                                  final String sqlCountNum, final int pageNumber, final int pageSize) {
        logger.info(sqlCountNum);
        int total = jdbcTemplate.queryForObject(sqlCountNum, Integer.class);
        int startIndex = (pageNumber - 1) * pageSize;
        if (startIndex < 0) {
            startIndex = 0;
        }
        logger.info(sql + " between " + startIndex + "and" + pageSize + " ");
        // jdbcTemplate.setFetchSize(startIndex);
        // jdbcTemplate.setMaxRows(pageSize);
        List rows = jdbcTemplate.queryForList(sql + " between " + startIndex + "and"
                + startIndex + pageSize + " ");
//        Pagination pagination = new Pagination(pageNumber, pageSize, total, rows);
        return new Pagination();
    }
    
//	public String sqlMap(final String key) {
//        try {
//            return CustomizedPropertyPlaceholderConfigurer.getContextProperty(key).toString();
//        } catch (Exception ex) {
//            logger.error(ex.getMessage());
//            return "";
//        }
//    }
    
    public Boolean batchSql(final String sql, final List<Object[]> values) {
        TransactionCallback<Boolean> callback = new TransactionCallback<Boolean>() {
            @Override
            public Boolean doInTransaction(final TransactionStatus transactionStatus) {
                if (values.size() > 0) {
                    jdbcTemplate.batchUpdate(sql, values);
                }
                return true;
            }
        };
        try {
            TransactionTemplate tt = new TransactionTemplate(transactionManager);
            return tt.execute(callback);
        } catch (Exception ex) {
            logger.error(sql);
            logger.error(ex.getMessage());
            return false;
        }
    }
    
    @SuppressWarnings("unchecked")
	public Boolean batchSqls(final LinkedList<String> sql,
            final LinkedList<Object[]>... values) {
        TransactionCallback<Boolean> callback = new TransactionCallback<Boolean>() {
            @Override
            public Boolean doInTransaction(final TransactionStatus transactionStatus) {
                int i = 0;
                for (LinkedList<Object[]> o : values) {
                    if (sql.size() < i + 1) {
                        break;
                    }
                    if (!o.isEmpty()) {
                        jdbcTemplate.batchUpdate(sql.get(i), o);
                    }
                    i++;
                }
                return true;
            }
        };
        try {
            TransactionTemplate tt = new TransactionTemplate(transactionManager);
            return tt.execute(callback);
        } catch (Exception ex) {
            logger.error("批量处理失败 fail : ", ex);
            return false;
        }
    }

    /**
     * 返回clazz类型对象List，要求clazz类型的成员变量名与sql中返回的字段名称相同
     * 
     * @param sql
     * @param args
     * @param clazz
     * @return
     */
    protected <T> List<T> queryForList(final String sql, final Object[] args,
            final Class<T> clazz) {
        List<Map<String, Object>> datas = this.jdbcTemplate.queryForList(sql, args);

        List<T> retList = new ArrayList<T>();
        try {
            // 遍历List中的所有数据
            for (Map<String, Object> data : datas) {
                // 以clazz中的成员变量为基准，遍历clazz类型的所有成员变量，依次到Map中取值，然后赋值，
                // 没有取到值的不进行赋值
                T distObj = this.mapObject(data, clazz);
                retList.add(distObj);
            }
            return retList;
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return null;
            // throw new RuntimeException(e);
        }
    }

    /**
     * 通过返回clazz类型对象List，要求clazz类型的成员变量名与sql中返回的字段名称相同
     * 
     * @param sql
     * @param args
     * @param clazz
     * @return
     */
    protected <T> List<T> queryForListByNamed(final String sql,
            final Map<String, Object> args, final Class<T> clazz) {
        List<Map<String, Object>> datas = this.namedParameterJdbcTemplate.queryForList(
                sql, args);

        List<T> retList = new ArrayList<T>();
        try {
            // 遍历List中的所有数据
            for (Map<String, Object> data : datas) {
                // 以clazz中的成员变量为基准，遍历clazz类型的所有成员变量，依次到Map中取值，然后赋值，
                // 没有取到值的不进行赋值
                T distObj = this.mapObject(data, clazz);
                retList.add(distObj);
            }
            return retList;
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return null;
            // throw new RuntimeException(e);
        }
    }

    /**
     * 返回clazz类型的对象
     * 
     * @param sql
     * @param args
     * @param clazz
     * @return
     */
    public <T> T queryForObject(final String sql, final Object[] args,
            final Class<T> clazz) {
        try {

            List<Map<String, Object>> list = this.jdbcTemplate.queryForList(sql, args);
            if (list != null && list.size() > 0) {
                Map<String, Object> data = list.get(0);
                if (data != null) {
                    T retObj = this.mapObject(data, clazz);
                    return retObj;
                }
            }

            return null;
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            // throw new RuntimeException(e);
            return null;
        }
    }

    /**
     * 返回clazz类型的实例，数据来源data，data中的key名称要与clazz的成员变量名称一致
     * 
     * @param clazz
     * @return
     * @throws
     * @throws Exception
     * @paramsql
     * @paramargs
     */
    private <T> T mapObject(final Map<String, Object> map, final Class<T> obj)
            throws Exception {
    	Field[] fields = obj.getDeclaredFields();
		T t = null;
		try {
			if (fields.length > 0) {
				t = obj.newInstance();
			}
			boolean flag;
			for (Field field : fields) {
				if (map.containsKey(field.getName())
						&& map.get(field.getName()) != null) {
					flag = false;
					if (!field.isAccessible()) {
						field.setAccessible(true);
						flag = true;
					}
					int m = field.getModifiers();
					if (Modifier.isFinal(m)&&Modifier.isStatic(m)) {
						// 什么都不做
						continue;
					}else if ((field.getType() == java.util.Date.class || field.getType() == java.sql.Date.class)
							&& map.get(field.getName()).getClass() != field.getType()) {// Date
						try {
							SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							field.set(t, format.parse(map.get(field.getName()).toString()));
						} catch (Exception e) {
							SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
							field.set(t, date_format.parse(map.get(field.getName()).toString()));
						}
					} else if (field.getType() == Timestamp.class
							&& map.get(field.getName()).getClass() != field
									.getType()) {// Timestamp
						field.set(t, Timestamp.valueOf(map.get(field.getName()).toString()));
					} else if (field.getType() == Long.class
							&& map.get(field.getName()).getClass() != field.getType()) {// Long
						field.set(t,Long.parseLong(map.get(field.getName()).toString()));
					} else if ((field.getType() == int.class || field.getType() == Integer.class)
							&& map.get(field.getName()).getClass() != field.getType()) {// Integer
						field.set(t, Integer.parseInt(map.get(field.getName()).toString()));
					} else if (field.getType() == BigDecimal.class
							&& map.get(field.getName()).getClass() != field.getType()) {//BigDecimal
						field.set(t,new BigDecimal(map.get(field.getName()).toString()));
					} else if ((field.getType() == Boolean.class || field.getType() == boolean.class)
							&& map.get(field.getName()).getClass() != field.getType()) {//Boolean
						field.set(t, Boolean.parseBoolean(map.get(field.getName()).toString()));
					} else if ((field.getType() == Short.class || field.getType() == short.class)
							&& map.get(field.getName()).getClass() != field.getType()) {//Short
						field.set(t, Short.parseShort(map.get(field.getName()).toString()));
					}else if ((field.getType() == Byte.class || field.getType() == byte.class)
							&& map.get(field.getName()).getClass() != field.getType()) {//Byte
						field.set(t, Byte.parseByte(map.get(field.getName()).toString()));
					}else if ((field.getType() == Long.class || field.getType() == long.class)
							&& map.get(field.getName()).getClass() != field.getType()) {//Long
						field.set(t, Long.parseLong(map.get(field.getName()).toString()));
					}else if ((field.getType() == Float.class || field.getType() == float.class)
							&& map.get(field.getName()).getClass() != field.getType()) {//Float
						field.set(t, Float.parseFloat(map.get(field.getName()).toString()));
					}else if ((field.getType() == Double.class || field.getType() == double.class)
							&& map.get(field.getName()).getClass() != field.getType()) {//Double
						field.set(t, Double.parseDouble(map.get(field.getName()).toString()));
					}else if ((field.getType() == Character.class || field.getType() == char.class)
							&& map.get(field.getName()).getClass() != field.getType()) {//Character
						//是否有问题待测试
						field.set(t, map.get(field.getName()).toString().charAt(0));
					} else {
						field.set(t, map.get(field.getName()));
					}
					if (flag) {
						field.setAccessible(false);
					}
				}
			}
		} catch (Exception e) {
			logger.error("将Map对象转换为Object对象时异常", e);
		}
		return t;
    }

    /**
     * xs 新增一条记录且返回主键Id
     * 
     * @param sql
     *            新增待执行sql
     * @param param
     *            参数
     * @return 主键ID
     */
    public int insertSqlAndReturnKeyId(final String sql, final Object[] param) {
        final String innersql = sql;
        final Object[] innerO = param;
        KeyHolder keyHolder = new GeneratedKeyHolder();
        try {
            jdbcTemplate.update(new PreparedStatementCreator() {
                @Override
                public PreparedStatement createPreparedStatement(final Connection con)
                        throws SQLException {
                    PreparedStatement ps = con.prepareStatement(innersql,
                            Statement.RETURN_GENERATED_KEYS);
                    for (int i = 0; i < innerO.length; i++) {
                        ps.setObject(i + 1, innerO[i]);
                    }

                    return ps;
                }
            }, keyHolder);
        } catch (DataAccessException e) {
        	throw new RuntimeException(e.getMessage(),e);
        }
        return keyHolder.getKey().intValue();

    }

    /**
     * @param sql
     *            业务sql
     * @param sqlCountNum
     *            数量sql
     * @param pageNumber
     *            开始
     * @param pageSize
     * @param clazz
     * @param args
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public Pagination JdbcTemplateUniversalPagingData(final String sql,
            final String sqlCountNum, final int pageNumber, final int pageSize,
            final Class clazz, final Object... args) {
        int total = 0;
        if (args == null) {
            total = jdbcTemplate.queryForObject(sqlCountNum, Integer.class);
        } else {
            total = jdbcTemplate.queryForObject(sqlCountNum, args, Integer.class);
        }
        int startIndex = (pageNumber-1) * pageSize;
        if (startIndex < 0) {
            startIndex = 0;
        }
        // jdbcTemplate.setFetchSize(startIndex);
        // jdbcTemplate.setMaxRows(pageSize);

        List rows = queryForList(sql + " limit " + startIndex + "," + pageSize, args,
                clazz);
        ;
        Pagination pagination = new Pagination();
        return pagination;
    }
    
    /**
     * @param sql         业务sql
     * @param sqlCountNum 数量sql
     * @param pageNumber  开始
     * @param pageSize
     * @param clazz
     * @param args
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public Pagination JdbcTemplateUniversalPagingMap(final String sql,
                                                     final String sqlCountNum, final int pageNumber, final int pageSize,
                                                     final Object... args) {
        int total = 0;
        if (args == null) {
            total = jdbcTemplate.queryForObject(sqlCountNum, Integer.class);
        } else {
            total = jdbcTemplate.queryForObject(sqlCountNum, args, Integer.class);
        }
        int startIndex = (pageNumber - 1) * pageSize;
        if (startIndex < 0) {
            startIndex = 0;
        }
        
        List rows = jdbcTemplate.queryForList(sql + " limit " + startIndex + ","
                + pageSize, args);
        Pagination page = new Pagination();
        return page;
    }

    /**
     * 通过list获取map，避免产生不必要的异常
     * 
     * @return
     */
    public Map<String, Object> queryForMapNoException(final String sql,
            final Object[] args) {
        Map<String, Object> data = null;
        List<Map<String, Object>> list = this.jdbcTemplate.queryForList(sql, args);
        if (list != null && list.size() > 0) {
            data = list.get(0);
        }
        return data;
    }
}
