package com.springbootweather.weatherservices;

import com.springbootweather.weathermodel.CityWeatherReport;

/*
    This class invokes the methods from the "OpenWeatherMap-API"
    provides the services to the weathercontroller.
 */
public class WeatherService {

     CityWeatherReport cityWeatherReport;

        public CityWeatherReport getCityWeather(){
//        // declaring object of "OpenWeatherMap" class
//        OpenWeatherMap owm = new OpenWeatherMap("");
//
//        // getting current weather data for the "London" cityWeatherReport
//        CurrentWeather cwd = owm.currentWeatherByCityName("London");
//
//        // checking data retrieval was successful or not
//        if (cwd.isValid()) {
//
//            // checking if cityWeatherReport name is available
//            if (cwd.hasCityName()) {
//                //printing cityWeatherReport name from the retrieved data
//                System.out.println("CityWeatherReport: " + cwd.getCityName());
//            }
//
//            // checking if max. temp. and min. temp. is available
//            if (cwd.getMainInstance().hasMaxTemperature() && cwd.getMainInstance().hasMinTemperature()) {
//                // printing the max./min. temperature
//                cityWeatherReport.setMaxTemp(cwd.getMainInstance().getMaxTemperature());
//                cityWeatherReport.setMinTemp(cwd.getMainInstance().getMinTemperature());
//            }
//        }
//        cityWeatherReport.setCityName("London");
//        cityWeatherReport.setMinTemp(10.2f);
//        cityWeatherReport.setMaxTemp(30.4f);

        return cityWeatherReport;
    }
}
