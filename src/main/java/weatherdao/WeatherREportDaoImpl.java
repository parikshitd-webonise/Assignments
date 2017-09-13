package weatherdao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import weathermodels.CityWeatherReport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

/*
    Implimentaion of the WeatherReportDao
 */
@Transactional
@Repository
public class WeatherREportDaoImpl implements WeatherReportDao {


    @PersistenceContext
    private EntityManager entityManager;

    /*
        method for saving the Data from the weatherForeCastingApp into repository
     */
    @Override
    public void saveWeatherReport(CityWeatherReport cityWeatherReport) {
        entityManager.persist(cityWeatherReport);
    }

    /*
        method for getting the data from repository
     */
    @Override
    public CityWeatherReport getWeatherReport(Date date) {
        return entityManager.find(CityWeatherReport.class, date);
    }
}
