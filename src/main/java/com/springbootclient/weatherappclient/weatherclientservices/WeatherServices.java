package com.springbootclient.weatherappclient.weatherclientservices;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.springbootclient.weatherappclient.weathermodels.CityWeatherReport;
import com.springbootclient.weatherappclient.weatherrepo.WeatherRepo;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.Calendar;
import java.util.Date;

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
        Iterable<CityWeatherReport> cityWeatherReports = weatherRepo.findAll();
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        Date previousDate = cal.getTime();
                CityWeatherReport previuosCityWeatherReport = new CityWeatherReport();
        for (CityWeatherReport cityWeatherReport: cityWeatherReports)
        {
            if((cityWeatherReport.getWeatherReportDate().equals(previousDate)))
            {
                previuosCityWeatherReport = cityWeatherReport;
                break;
            }
            else
            {
                previuosCityWeatherReport = null;
            }
        }
        return previuosCityWeatherReport;
    }


    //checking before the saving the cityWeatherReport is exists into the sustem or not
    public boolean isWeatherReportExists(CityWeatherReport cityWeatherReport)
    {
        logger.debug("Class:WeatherServices, Method:isWeatherReportExists, cityWeatherReport:" +cityWeatherReport);
        return weatherRepo.exists(cityWeatherReport.getId());
    }

}
