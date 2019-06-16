package com.pm25.dao;

import com.pm25.domain.PM25;
import com.pm25.dto.AreaAQIdto;
import com.pm25.dto.PM25dto;
import com.pm25.utils.DBConnection;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.*;

public class PM25Dao {

    public String getLastTime() {
        Connection conn = null;
        String sql = "SELECT MAX(t_pm25.`f_time`) as time FROM t_pm25";
        conn = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        String result = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result = resultSet.getDate("time").toString() + " " + resultSet.getTime("time").toString();
                ;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeDB(conn, preparedStatement, resultSet);
        }
        return result;
    }

    public List<AreaAQIdto> selectAreaAQIByTime(String station, String time) {
        Connection conn = null;
        System.out.println(station + "=========" + time);
        PreparedStatement preparedStatement = null;
        String sql = "{CALL get_AQI(?,?)}"; //调用存储过程
        CallableStatement cstm = null;
        List<AreaAQIdto> list_AQI = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            cstm = conn.prepareCall(sql); //实例化对象cstm
            cstm.setString(1, station); //存储过程输入参数
            cstm.setString(2, time);

            rs = cstm.executeQuery();
            list_AQI = new ArrayList<>();
            while (rs.next()) {
                AreaAQIdto areaAQIdto = new AreaAQIdto();
                areaAQIdto.setAQI(rs.getInt("f_AQI"));
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(rs.getDate("f_time").toString());
                stringBuilder.append(" ");
                stringBuilder.append(rs.getTime("f_time").getHours());
                stringBuilder.append("点");
                areaAQIdto.setTime(stringBuilder.toString());
                list_AQI.add(areaAQIdto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                cstm.close();
                DBConnection.closeDB(conn, preparedStatement, rs);


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list_AQI;

    }

    public List<PM25> selectPlaceByTimeAndArea(String sql) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;


        List<PM25> list_place = null;
        ResultSet resultSet = null;

        conn = DBConnection.getConnection();
        try {
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            list_place = new ArrayList<>();
            while (resultSet.next()) {
                PM25 pm25 = new PM25();
                pm25.setId(resultSet.getInt("f_id"));
                pm25.setAreaCode(resultSet.getString("f_areacode"));
                pm25.setArea(resultSet.getString("f_area"));
                pm25.setTime(resultSet.getDate("f_time").toString());
                pm25.setPlace(resultSet.getString("f_place"));

                pm25.setAQI(resultSet.getInt("f_AQI"));
                pm25.setAQItype(resultSet.getString("f_AQItype"));
                pm25.setPM25per1h(resultSet.getInt("f_PM25per1h"));
                pm25.setPM10per1h(resultSet.getInt("f_PM10per1h"));
                pm25.setCOper1h(resultSet.getInt("f_COper1h"));
                pm25.setNO2per1h(resultSet.getInt("f_NO2per1h"));
                pm25.setO3per1h(resultSet.getInt("f_O3per1h"));
                pm25.setO3per8h(resultSet.getInt("f_O3per8h"));
                pm25.setSO2per1h(resultSet.getInt("f_SO2per1h"));
                pm25.setMajorPollutant(resultSet.getString("f_majorpollutant"));

                list_place.add(pm25);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeDB(conn, preparedStatement, resultSet);
        }
        return list_place;
    }

    public List<PM25dto> selectTimeEndData() {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        String sql = "SELECT f_area,f_PM25per1h FROM t_pm25 WHERE t_pm25.`f_place` LIKE '%市（总）' AND t_pm25.`f_time` = (SELECT MAX(t_pm25.`f_time`) FROM t_pm25)";

        List<PM25dto> list = null;
        ResultSet resultSet = null;
        conn = DBConnection.getConnection();
        try {
            list = new ArrayList<>();
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PM25dto pm25dto = new PM25dto();
                pm25dto.setName(resultSet.getString("f_area"));
                pm25dto.setValue(resultSet.getInt("f_PM25per1h"));
                list.add(pm25dto);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeDB(conn, preparedStatement, resultSet);
        }
        return list;
    }
}
