package com.scaffolding.demo.dto;

import lombok.Data;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/12/24 14:44
 */
@Data
public class Db {

    public Db() {

    }

    public Db(String driver, String url, String username, String pwd) {
        this.driver = driver;
        this.url = url;
        this.username = username;
        this.pwd = pwd;
    }

    private String driver = "com.mysql.cj.jdbc.Driver";

    private String url;

    private String username;

    private String pwd;
}
