package com.example.dao.master;

import com.example.vo.UserVo;
import org.springframework.stereotype.Repository;

/**
 * @author LingYin.Fan
 * @version 1.0.0
 * @ClassName UserDao.java
 * @Description TODO
 * @createTime 2019年11月15日 16:49:00
 */
@Repository
public interface UserDao {

    UserVo findById(Long id);
}
