package com.example.vo;

import lombok.Data;

/**
 * @author LingYin.Fan
 * @version 1.0.0
 * @ClassName SchoolVo.java
 * @Description TODO
 * @createTime 2019年11月15日 16:48:00
 */
@Data
public class UserVo {

    private long id;
    private String userName;
    private SchoolVo schoolVo;
}
