package com.pm25.controller;

import com.pm25.domain.PM25;
import com.pm25.dto.AreaAQIdto;
import com.pm25.service.PM25Service;
import com.pm25.serviceImpl.PM25ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@ResponseBody

public class PM25Controller {
    @Autowired
    PM25Service pm25Service;

    //列出折线图 24时段
    @RequestMapping(value = "/listAreaAQIByTime")
    public List<AreaAQIdto> listAreaAQIByTime(Map<String, String> map) {
        String station = map.get("station");//传过来的市名  ***市（总）
        String time = map.get("time");
        List<AreaAQIdto> list = pm25Service.getAreaAQIByTime(station, time);
        return list;
    }

    //列出当前时间某地区各个站点的测量数据
    // SELECT * FROM t_pm25 WHERE f_area="济南市" AND f_time="2014-08-29 12:00:00" "
    @RequestMapping(value = "/listPlaceByTimeAndArea")
    public List<PM25> listPlaceByTimeAndArea(Map<String, String> map) {
        String station = map.get("station");//直传 ***市 即可
        String time = map.get("time");
        List<PM25> list = pm25Service.getPlaceByTimeAndArea(station, time);
        return list;
    }
}
