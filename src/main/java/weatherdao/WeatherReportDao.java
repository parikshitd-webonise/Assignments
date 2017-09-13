package weatherdao;

import weathermodels.CityWeatherReport;

import java.util.Date;

/*
    Dao interface for CRUD operations
 */
public interface WeatherReportDao {

   void saveWeatherReport(CityWeatherReport cityWeatherReport);
   CityWeatherReport getWeatherReport(Date date);
}
