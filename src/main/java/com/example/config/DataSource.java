package com.example.config;

import java.lang.annotation.*;

/**
 * 数据源注解
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface DataSource {

    /** 数据源名称 */
    DataSourceEnum value();
}
