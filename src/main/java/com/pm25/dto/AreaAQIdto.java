package com.pm25.dto;

import java.sql.Timestamp;
import java.util.Date;

public class AreaAQIdto {
    private Integer AQI;
    private String time;

    public Integer getAQI() {
        return AQI;
    }

    public void setAQI(Integer AQI) {
        this.AQI = AQI;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
