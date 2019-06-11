package com.pm25.utils;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DBConnection {
    private static final String url = "jdbc:mysql://localhost:3306/pm25_db?serverTimezone=GMT%2B8";
    private static final String user = "root";//用户名
    private static final String password = "123456";//密码
    private static final String className = "com.mysql.jdbc.Driver";


    public static Connection getConnection() {
        Connection conn = null;

        try {

            Class.forName(className);
            try {
                conn = DriverManager.getConnection(url, user, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static void closeDB(Connection conn, PreparedStatement pstm,
                               ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (pstm != null) {
            try {
                pstm.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}


