package com.pm25.serviceImpl;


import com.pm25.dao.PM25Dao;
import com.pm25.domain.PM25;
import com.pm25.dto.AreaAQIdto;
import com.pm25.dto.PM25dto;
import com.pm25.service.PM25Service;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pm25Service")
public class PM25ServiceImpl implements PM25Service {
    PM25Dao pm25Dao;
//SELECT MAX(t_pm25.`f_time`) FROM t_pm25

    public List<AreaAQIdto> getAreaAQIByTime(String station, String time) {
        pm25Dao = new PM25Dao();
        List<AreaAQIdto> list = null;
        if (time == null) {
            list = pm25Dao.selectAreaAQIByTime(station, pm25Dao.getLastTime());
        } else {
            list = pm25Dao.selectAreaAQIByTime(station, time);
        }
        return list;
    }

    @Override
    public List<PM25> getPlaceByTimeAndArea(String station, String time) {
        pm25Dao = new PM25Dao();
        List<PM25> list;
        if (time != null) {
            String sql = "SELECT * FROM t_pm25 WHERE f_area='" + station + "' AND f_time='" + time + "' ";
            list = pm25Dao.selectPlaceByTimeAndArea(sql);
        } else {
            String sql = "SELECT * FROM t_pm25 WHERE f_area='" + station + "' AND t_pm25.`f_time` = (SELECT MAX(t_pm25.`f_time`) FROM t_pm25)";
            list = pm25Dao.selectPlaceByTimeAndArea(sql);
        }

        return list;
    }

    @Override
    public List<PM25dto> getTimeEndData() {
        pm25Dao = new PM25Dao();
        List<PM25dto> list = pm25Dao.selectTimeEndData();
        return list;
    }
}
