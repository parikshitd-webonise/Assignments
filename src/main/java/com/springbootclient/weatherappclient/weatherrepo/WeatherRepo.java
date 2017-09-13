package com.springbootclient.weatherappclient.weatherrepo;

import org.springframework.data.repository.CrudRepository;
import com.springbootclient.weatherappclient.weathermodels.CityWeatherReport;

public interface WeatherRepo extends CrudRepository<CityWeatherReport, Integer>{

}
