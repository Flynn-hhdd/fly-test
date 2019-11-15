package com.example.config;

import java.util.Random;

/**
 * 动态数据源持有者
 */
public class DynamicDataSourceHolder {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>();
    
    public static int dataSourceMasterSize = 1;

    public static int dataSourceSlaveSize = 1;

    private static Random random = new Random();

    /**
     * 获取数据源对应的key
     * 
     * @return String 数据源对应的key
     */
    public static String getDataSourceType() {
    	if(null == threadLocal.get()){
    		DynamicDataSourceHolder.setDataSourceTypeSlave();
    	}
        return threadLocal.get();
    }
    
    /**
     * 设置数据源为主库数据源
     */
    public static void setDataSourceTypeMaster() {
    	threadLocal.set("MASTER");
    }
    
    /**
     * 设置数据源为从库数据源
     */
    public static void setDataSourceTypeSlave() {
    	int randomSlave = random.nextInt(dataSourceSlaveSize);
    	threadLocal.set("SLAVE"+(randomSlave+1));
    }
    
    /**
     * 清除数据源
     */
    public static void clearDataSourceType() {
    	threadLocal.remove();
    }
}
