package weatherclient;


import weathermodels.CityWeatherReport;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/*
    ClientClass for the consuming the weatherForeCastApplication
 */
public class WeatherAppClient {

    // method for getting the current weather details from the weatherForeCastApplication
    public void getweatherDetails(){
        Client client = ClientBuilder.newClient();
        WebTarget base = client.target("https://localhost:8080/weatherforecast/save");
        CityWeatherReport cityWeatherReport = base.request(MediaType.APPLICATION_JSON).get(CityWeatherReport.class);
        System.out.println("City Name: " + cityWeatherReport.getCityName() +  "Temperature: " + cityWeatherReport.getTemp()
                + "Date: " + cityWeatherReport.getWeatherReportDate());

    }

    public void getPreviousWeatherReposts(){
        Client client = ClientBuilder.newClient();
        WebTarget base = client.target("https://localhost:8080/getprevoiusreports/get");
        CityWeatherReport cityWeatherReport = base.request(MediaType.APPLICATION_JSON).get(CityWeatherReport.class);
        System.out.println("City Name: " + cityWeatherReport.getCityName() +  "Temperature: " + cityWeatherReport.getTemp()
                + "Date: " + cityWeatherReport.getWeatherReportDate());
    }

    public static void main(String[] args) {
        WeatherAppClient weatherAppClient = new WeatherAppClient();
        weatherAppClient.getweatherDetails();
        weatherAppClient.getPreviousWeatherReposts();
    }

}
