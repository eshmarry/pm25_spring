package com.pm25.text;

import com.pm25.dto.PM25dto;
import com.pm25.service.AreaService;
import com.pm25.service.PM25Service;
import com.pm25.serviceImpl.AreaServiceImpl;
import com.pm25.serviceImpl.PM25ServiceImpl;
import com.pm25.utils.DBConnection;

import java.sql.*;
import java.util.List;

public class MGBText {
    public static void main(String[] args) {
     /*   AreaService areaService;
        areaService = new AreaServiceImpl();
        List<String> area_list =  areaService.getAllArea();
        for(String s:area_list){
            System.out.println(s+"-----");
        }*/
        PM25Service pm25Service = new PM25ServiceImpl();
        List<PM25dto> timeEndData = pm25Service.getTimeEndData();


    }
}
