package com.springbootclient.weatherappclient.weatherclientservices;

import org.springframework.beans.factory.annotation.Autowired;
import com.springbootclient.weatherappclient.weathermodels.CityWeatherReport;
import com.springbootclient.weatherappclient.weatherrepo.WeatherRepo;

public class WeatherServices {


    @Autowired
    WeatherRepo weatherRepo;

    public CityWeatherReport saveWeatherReports(CityWeatherReport cityWeatherReport){
        weatherRepo.save(cityWeatherReport);
        return cityWeatherReport;
    }

    public CityWeatherReport getWeatherReports(int id){
        CityWeatherReport cityWeatherReport = weatherRepo.findOne(id);
        return cityWeatherReport;
    }

    public boolean isWeatherReportExist(CityWeatherReport cityWeatherReport){
        return weatherRepo.exists(cityWeatherReport.getId());

    }

}
