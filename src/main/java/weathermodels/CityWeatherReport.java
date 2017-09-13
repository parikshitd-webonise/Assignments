package weathermodels;

import javax.persistence.*;
import java.util.Date;

/*
    The class is persistent clas for sving the details into database
 */
@Entity
@Table(name = "cityweatherreport")
public class CityWeatherReport {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String cityName;
    private float maxTemp;
    private float minTemp;
    private float temp;
    private Date weatherReportDate;

    public float getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(float minTemp) {
        this.minTemp = minTemp;
    }

    public float getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(float maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public Date getWeatherReportDate() {
        return weatherReportDate;
    }

    public void setWeatherReportDate(Date weatherReportDate) {
        this.weatherReportDate = weatherReportDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
