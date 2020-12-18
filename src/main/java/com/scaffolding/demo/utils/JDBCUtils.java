package com.scaffolding.demo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author lijiannan
 * @version 1.0
 * @date 2020/12/18 16:30
 */
public class JDBCUtils {

    /**
     * 获取连接
     * @param driver
     * @param url
     * @param username
     * @param pwd
     * @return
     */
    public static Connection getConnection(String driver, String url, String username, String pwd) {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, username, pwd);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


}
