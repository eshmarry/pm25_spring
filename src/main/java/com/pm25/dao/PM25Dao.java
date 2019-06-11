package com.pm25.dao;

import com.pm25.domain.PM25;
import com.pm25.dto.AreaAQIdto;
import com.pm25.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PM25Dao {


    public List<AreaAQIdto> selectAreaAQIByTime(String station, String time) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        String sql = "{CALL get_AQI(?,?)}"; //调用存储过程
        CallableStatement cstm = null;
        List<AreaAQIdto> list_AQI = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            cstm = conn.prepareCall(sql); //实例化对象cstm
            cstm.setString(1, station); //存储过程输入参数

            cstm.setTimestamp(2, Timestamp.valueOf(time));

            rs = cstm.executeQuery();
            list_AQI = new ArrayList<>();
            while (rs.next()) {
                AreaAQIdto areaAQIdto = new AreaAQIdto();
                areaAQIdto.setAQI(rs.getInt("f_AQI"));
                areaAQIdto.setTime(rs.getDate("f_time"));
                list_AQI.add(areaAQIdto);

            }


        } catch (SQLException e) {
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

    public List<PM25> selectPlaceByTimeAndArea(String station, String time) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM t_pm25 WHERE f_area='"+station+"' AND f_time='"+time+"' ";

        List<PM25> list_place =null;
        ResultSet resultSet = null;

        conn = DBConnection.getConnection();
        try {
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            list_place = new ArrayList<>();
            while(resultSet.next()){
                PM25 pm25 = new PM25();
                pm25.setId(resultSet.getInt("f_id"));
                pm25.setAreaCode(resultSet.getString("f_areacode"));
                pm25.setArea(resultSet.getString("f_area"));
                pm25.setTime(resultSet.getDate("f_time"));
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
                System.out.println(pm25.toString());
                list_place.add(pm25);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnection.closeDB(conn,preparedStatement,resultSet);
        }
        return list_place;
    }
}
