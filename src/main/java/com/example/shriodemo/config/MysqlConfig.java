package com.example.shriodemo.config;

/*
 * @Author liuxin
 * @Description //TODO
 **/

import org.hibernate.dialect.MySQL5InnoDBDialect;
import org.hibernate.dialect.MySQLInnoDBDialect;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.stereotype.Component;

/**
 * 自定义JPA储存编码为utf8编码
 */

public class MysqlConfig extends MySQL5InnoDBDialect {
    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}