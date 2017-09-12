package com.springbootweather.weathermodel;

import java.util.Date;

/*
* The model class for the storing data about
* the weather.
* */
public class CityWeatherReport {

    private String cityName;
    private float maxTemp;
    private float minTemp;
    private float temp;
    private Date weatherReportDate;

    public float getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(float minTemp) {
        this.minTemp = minTemp;
    }

    public float getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(float maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public Date getWeatherReportDate() {
        return weatherReportDate;
    }

    public void setWeatherReportDate(Date weatherReportDate) {
        this.weatherReportDate = weatherReportDate;
    }
}
