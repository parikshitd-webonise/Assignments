package com.springbootclient.weatherappclient.weatherrepo;

import org.springframework.data.repository.CrudRepository;
import com.springbootclient.weatherappclient.weathermodels.CityWeatherReport;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepo extends CrudRepository<CityWeatherReport, Integer>{

}
