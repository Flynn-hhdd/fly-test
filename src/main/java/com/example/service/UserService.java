package com.example.service;

import com.example.vo.UserVo;

/**
 * @author LingYin.Fan
 * @version 1.0.0
 * @ClassName UserService.java
 * @Description TODO
 * @createTime 2019年11月15日 16:51:00
 */
public interface UserService {

    UserVo getUser(Long id);
}
