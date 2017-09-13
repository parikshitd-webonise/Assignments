package weatherclientservices;

import org.springframework.beans.factory.annotation.Autowired;
import weatherdao.WeatherREportDaoImpl;
import weatherdao.WeatherReportDao;
import weathermodels.CityWeatherReport;

import java.util.Date;

public class WeatherServices {

    WeatherReportDao weatherReportDao = new WeatherREportDaoImpl();

    public void saveWeatherReports(CityWeatherReport cityWeatherReport){
        weatherReportDao.saveWeatherReport(cityWeatherReport);
    }

    public CityWeatherReport getWeatherReports(Date date){
        CityWeatherReport cityWeatherReport = weatherReportDao.getWeatherReport(date);
        return cityWeatherReport;
    }

}
