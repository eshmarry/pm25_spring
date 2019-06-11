package com.pm25.dto;

import java.sql.Timestamp;
import java.util.Date;

public class AreaAQIdto {
    private Integer AQI;
    private Date time;

    public Integer getAQI() {
        return AQI;
    }

    public void setAQI(Integer AQI) {
        this.AQI = AQI;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
