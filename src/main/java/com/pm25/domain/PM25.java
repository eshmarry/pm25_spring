package com.pm25.domain;

import java.util.Date;

public class PM25 {
    private int id;
    private String areaCode;
    private String area;
    private String time;
    private String place;
    private int AQI;
    private String AQItype;
    private int PM25per1h;
    private int PM10per1h;
    private int COper1h;
    private int NO2per1h;
    private int O3per1h;
    private int O3per8h;
    private int SO2per1h;
    private String majorPollutant;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getAQI() {
        return AQI;
    }

    public void setAQI(int AQI) {
        this.AQI = AQI;
    }

    public String getAQItype() {
        return AQItype;
    }

    public void setAQItype(String AQItype) {
        this.AQItype = AQItype;
    }

    public int getPM25per1h() {
        return PM25per1h;
    }

    public void setPM25per1h(int PM25per1h) {
        this.PM25per1h = PM25per1h;
    }

    public int getPM10per1h() {
        return PM10per1h;
    }

    public void setPM10per1h(int PM10per1h) {
        this.PM10per1h = PM10per1h;
    }

    public int getCOper1h() {
        return COper1h;
    }

    public void setCOper1h(int COper1h) {
        this.COper1h = COper1h;
    }

    public int getNO2per1h() {
        return NO2per1h;
    }

    public void setNO2per1h(int NO2per1h) {
        this.NO2per1h = NO2per1h;
    }

    public int getO3per1h() {
        return O3per1h;
    }

    public void setO3per1h(int o3per1h) {
        O3per1h = o3per1h;
    }

    public int getO3per8h() {
        return O3per8h;
    }

    public void setO3per8h(int o3per8h) {
        O3per8h = o3per8h;
    }

    public int getSO2per1h() {
        return SO2per1h;
    }

    public void setSO2per1h(int SO2per1h) {
        this.SO2per1h = SO2per1h;
    }

    public String getMajorPollutant() {
        return majorPollutant;
    }

    public void setMajorPollutant(String majorPollutant) {
        this.majorPollutant = majorPollutant;
    }

    @Override
    public String toString() {
        return "PM25{" +
                "id=" + id +
                ", areaCode='" + areaCode + '\'' +
                ", area='" + area + '\'' +
                ", time=" + time +
                ", place='" + place + '\'' +
                ", AQI=" + AQI +
                ", AQItype='" + AQItype + '\'' +
                ", PM25per1h=" + PM25per1h +
                ", PM10per1h=" + PM10per1h +
                ", COper1h=" + COper1h +
                ", NO2per1h=" + NO2per1h +
                ", O3per1h=" + O3per1h +
                ", O3per8h=" + O3per8h +
                ", SO2per1h=" + SO2per1h +
                ", majorPollutant='" + majorPollutant + '\'' +
                '}';
    }
}
