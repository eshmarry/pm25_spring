package com.pm25.controller;

import com.pm25.domain.PM25;
import com.pm25.dto.AreaAQIdto;
import com.pm25.dto.PM25dto;
import com.pm25.service.PM25Service;
import com.pm25.serviceImpl.PM25ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@CrossOrigin(origins = "http://localhost:8081")
public class PM25Controller {
    @Autowired
    PM25Service pm25Service;

    //列出数据库最后的的总的数据

    /**
     * SELECT f_area,f_PM25per1h FROM t_pm25
     * WHERE t_pm25.`f_place` LIKE '%市（总）' AND t_pm25.`f_time` = (SELECT MAX(t_pm25.`f_time`) FROM t_pm25)
     *
     * @return
     */
    @RequestMapping(value = "/listTimeEndData")
    public List<PM25dto> listTimeEndData() {
        return pm25Service.getTimeEndData();
    }

    //列出折线图 24时段
    @RequestMapping(value = "/listAreaAQIByTime")
    public List<AreaAQIdto> listAreaAQIByTime(@RequestBody Map<String, String> map) {
        String station = map.get("station");//传过来的市名  ***市（总）
        String date = map.get("date");
        List<AreaAQIdto> list = pm25Service.getAreaAQIByTime(station, date);
        return list;
    }

    //列出当前时间某地区各个站点的测量数据
    // SELECT * FROM t_pm25 WHERE f_area="济南市" AND f_time="2014-08-29 12:00:00" "
    @RequestMapping(value = "/listPlaceByTimeAndArea",method = RequestMethod.POST)
    public List<PM25> listPlaceByTimeAndArea(@RequestBody Map<String, String> map) {
        String station = map.get("station");//直传 ***市 即可
        System.out.println(station+"=========");
        String date = map.get("date");
        List<PM25> list = pm25Service.getPlaceByTimeAndArea(station, date);
        return list;
    }
}
