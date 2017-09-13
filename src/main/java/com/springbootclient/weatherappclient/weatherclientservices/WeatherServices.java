package com.springbootclient.weatherappclient.weatherclientservices;

import com.springbootclient.weatherappclient.weatherclientcontroller.ClientController;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.springbootclient.weatherappclient.weathermodels.CityWeatherReport;
import com.springbootclient.weatherappclient.weatherrepo.WeatherRepo;
import org.springframework.stereotype.Service;

@Service
public class WeatherServices {

    @Autowired
    WeatherRepo weatherRepo;
    public static final org.slf4j.Logger logger = LoggerFactory.getLogger(WeatherServices.class);

    //Saving the cityWeatherReport object into the database
    public CityWeatherReport saveWeatherReports(CityWeatherReport cityWeatherReport)
    {
        logger.debug("Class:WeatherServices, Method:saveWeatherReports, cityWeatherReport: " + cityWeatherReport.toString());
        weatherRepo.save(cityWeatherReport);
        return cityWeatherReport;
    }

    //Getting the cityWeatherReport from the database on the basis of the Id
    public CityWeatherReport getWeatherReports(int id)
    {
        logger.debug("Class:WeatherServices, Method:getWeatherReports, id: " + id);
        System.out.println("Debug:id " + id);
        CityWeatherReport cityWeatherReport = weatherRepo.findOne(id);
        return cityWeatherReport;
    }

    //checking before the saving the cityWeatherReport is exists into the sustem or not
    public boolean isWeatherReportExists(CityWeatherReport cityWeatherReport)
    {
        logger.debug("Class:WeatherServices, Method:isWeatherReportExists, cityWeatherReport:" +cityWeatherReport);
        return weatherRepo.exists(cityWeatherReport.getId());

    }

}
