package com.scaffolding.demo.utils;

import com.scaffolding.demo.dto.Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/12/18 16:30
 */
public class JDBCUtils {


    /**
     * 获取连接
     *
     * @param db
     * @return
     */
    public static Connection init(Db db) {
        try {
            Class.forName(db.getDriver());
            return DriverManager.getConnection(db.getUrl(), db.getUsername(), db.getPwd());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


}
