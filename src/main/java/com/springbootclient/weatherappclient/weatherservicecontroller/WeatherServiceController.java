package com.springbootclient.weatherappclient.weatherservicecontroller;
import com.springbootclient.weatherappclient.customerrors.CustomErrorTypes;
import com.springbootclient.weatherappclient.weatherclientservices.WeatherServices;
import com.springbootclient.weatherappclient.weathermodels.CityWeatherReport;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Date;

//Rest controller class for client
@RestController
@RequestMapping("/weatherappclient")
public class WeatherServiceController
{

    public static final org.slf4j.Logger logger = LoggerFactory.getLogger(WeatherServiceController.class);

    @Autowired
    WeatherServices weatherServices;


    //method for returning JSON object
    @RequestMapping(value = "/getweather", method=RequestMethod.GET)
    public CityWeatherReport  getWeather(@RequestParam(value="cityname", required=false, defaultValue="Pune") String cityName)
    {
        logger.info("Class:WeatherServiceController, Method:sayHello, Hello");
        return new CityWeatherReport(7, "NY", 20.5f, 25.5f, 20.0f, new Date());
    }


    //method for saving JASON object
    @RequestMapping(value = "/save/", method = RequestMethod.POST)
    public ResponseEntity<?> saveWeatherReport(@RequestBody CityWeatherReport cityWeatherReport, UriComponentsBuilder ucBuilder)
    {
        logger.info("Class:WeatherServiceController, Method:saveWeatherReport, Saving User");
        logger.info("Class:WeatherServiceController, Method:saveWeatherReport, Saving User, cityWeatherReport: " +cityWeatherReport);

        if(weatherServices.isWeatherReportExists(cityWeatherReport))
        {
            return new ResponseEntity(new CustomErrorTypes("Unable to create. A WeatherReport with Id " +
                    cityWeatherReport.getId() + " already exist."), HttpStatus.CONFLICT);
        }
        weatherServices.saveWeatherReports(cityWeatherReport);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/weatherappclient/save/{id}").buildAndExpand(cityWeatherReport.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }


    //Method for returning JSON object on the basis of the Id
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getWeatherReport(@PathVariable("id") int id)
    {
        logger.debug("Class:WeatherServiceController, Method:getWeatherReport, Fetching User with id {}", +id);

        CityWeatherReport cityWeatherReport = weatherServices.getWeatherReports(id);
        if(cityWeatherReport == null)
        {
            return new ResponseEntity(new CustomErrorTypes("Weather Report with id " + id
                     + "Not Found" ), HttpStatus.NOT_FOUND);
        }
        logger.debug("Class:WeatherServiceController, Method:getWeatherReport, cityWeatherReport: " + cityWeatherReport);
        return new ResponseEntity<CityWeatherReport>(cityWeatherReport, HttpStatus.OK);
    }
}