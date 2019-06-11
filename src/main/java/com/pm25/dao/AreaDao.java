package com.pm25.dao;

import com.pm25.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AreaDao {

    public List<String> selectAllArea() {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT f_area FROM t_config";
        List<String> list = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = conn.prepareStatement(sql);
            resultSet = ps.executeQuery();
            list = new ArrayList<>();
            while (resultSet.next()) {
                list.add(resultSet.getString("f_area"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeDB(conn, ps, resultSet);
        }
        return list;
    }
}
