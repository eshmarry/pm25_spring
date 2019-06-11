package com.pm25.controller;

import com.pm25.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
public class AreaController {
    @Autowired
   AreaService areaService;
    //获取所有的地点
    @RequestMapping(value="/listAllArea",method = RequestMethod.GET)
    public List<String> listAllArea(){

        List<String> area_list =  areaService.getAllArea();
        return area_list;
    }
}
