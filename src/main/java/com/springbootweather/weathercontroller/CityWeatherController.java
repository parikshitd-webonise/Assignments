package com.springbootweather.weathercontroller;


import com.springbootweather.weatherservices.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class CityWeatherController {

    @RequestMapping(value= "/getweatherreport", method = RequestMethod.GET)



    public String getToadysWeatherReport(Model model){
//        CityWeatherReport city =  weatherService.getCityWeather();
//        model.addAttribute("city", city);
        return "weather";
    }

}
