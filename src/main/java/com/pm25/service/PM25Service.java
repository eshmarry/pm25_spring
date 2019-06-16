package com.pm25.service;

import com.pm25.domain.PM25;
import com.pm25.dto.AreaAQIdto;
import com.pm25.dto.PM25dto;


import java.util.List;

public interface PM25Service {
    List<AreaAQIdto> getAreaAQIByTime(String station, String time);

    List<PM25> getPlaceByTimeAndArea(String station, String time);

    List<PM25dto> getTimeEndData();
}
