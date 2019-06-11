package com.pm25.serviceImpl;


import com.pm25.dao.PM25Dao;
import com.pm25.domain.PM25;
import com.pm25.dto.AreaAQIdto;
import com.pm25.service.PM25Service;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("pm25Service")
public class PM25ServiceImpl implements PM25Service {
    PM25Dao pm25Dao;

    //SELECT * FROM t_pm25 WHERE f_place ='济南市（总）' AND f_time BETWEEN '2014-08-29 12:00:00' AND '2014-08-29 19:00:00'
    public List<AreaAQIdto> getAreaAQIByTime(String station, String time) {
        pm25Dao = new PM25Dao();
        List<AreaAQIdto> list = pm25Dao.selectAreaAQIByTime(station, time);
        return list;
    }

    @Override
    public List<PM25> getPlaceByTimeAndArea(String station, String time) {
        pm25Dao = new PM25Dao();
        List<PM25> list = pm25Dao.selectPlaceByTimeAndArea( station,  time);
        return null;
    }
}
