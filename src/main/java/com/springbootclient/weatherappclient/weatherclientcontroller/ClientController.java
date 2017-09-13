package com.springbootclient.weatherappclient.weatherclientcontroller;

import com.springbootclient.weatherappclient.customerrors.CustomErrorTypes;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import com.springbootclient.weatherappclient.weatherclientservices.WeatherServices;
import com.springbootclient.weatherappclient.weathermodels.CityWeatherReport;

//Rest controller class for client
@RestController
@RequestMapping("/weatherappclient")
public class ClientController {

    public static final org.slf4j.Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    WeatherServices weatherServices;

    @RequestMapping(value = "/hello", method=RequestMethod.GET)
    public String  sayHello(@RequestParam(value="cityname", required=false, defaultValue="Pune") String cityName) {
        return "index";
    }

    @RequestMapping(value = "/save/", method = RequestMethod.POST)
    public ResponseEntity<?> saveWeatherReport(@RequestBody CityWeatherReport cityWeatherReport, UriComponentsBuilder ucBuilder){
        logger.info("Class:ClientController, Method:saveWeatherReport, Saving User");

        if(weatherServices.isWeatherReportExist(cityWeatherReport))
        {
            return new ResponseEntity(new CustomErrorTypes("Unable to create. A WeatherReport with Id " +
                    cityWeatherReport.getId() + " already exist."), HttpStatus.CONFLICT);
        }
        weatherServices.saveWeatherReports(cityWeatherReport);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/weatherappclient/save/{id}").buildAndExpand(cityWeatherReport.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getWeatherReport(@PathVariable("id") int id){
        logger.info("Class:ClientController, Method:getWeatherReport, Fetching User with id {}", +id);

        CityWeatherReport cityWeatherReport = weatherServices.getWeatherReports(id);
         if(cityWeatherReport == null){
             return new ResponseEntity(new CustomErrorTypes("Weather Report with id " + id
                     + "Not Found" ), HttpStatus.NOT_FOUND);
         }
         return new ResponseEntity<CityWeatherReport>(cityWeatherReport, HttpStatus.OK);
    }

}