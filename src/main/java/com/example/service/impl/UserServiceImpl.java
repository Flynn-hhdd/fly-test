package com.example.service.impl;

import com.example.dao.slave.SchoolDao;
import com.example.dao.master.UserDao;
import com.example.service.UserService;
import com.example.vo.SchoolVo;
import com.example.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private SchoolDao schoolDao;

    @Override
    public UserVo getUser(Long id) {
        UserVo userVo = userDao.findById(id);
        SchoolVo schoolVo = schoolDao.findByName("清华");
        userVo.setSchoolVo(schoolVo);
        return userVo;
    }

}