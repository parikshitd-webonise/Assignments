package weatherclientcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import weatherclientservices.WeatherServices;
import weathermodels.CityWeatherReport;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.Date;
import java.util.Map;

//Rest controller class for client
@RestController
@RequestMapping("/weatherappclient")
public class ClientController {

//    @Autowired
//    WeatherServices weatherServices;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String printHello(Map<String, Object> model){
        model.put("name", "Parikshit");
        return "index";
    }
//
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response saveWeatherReport(@RequestParam CityWeatherReport cityWeatherReport){
//
//        weatherServices.saveWeatherReports(cityWeatherReport);
//        return Response.ok(cityWeatherReport).build();
//
//    }
//
//   @RequestMapping("/get")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getPreviousWeatherReports(){
//
//        Date date = new Date();
//        CityWeatherReport cityWeatherReport = weatherServices.getWeatherReports(date);
//        return Response.created(URI.create("/weatherappclient/"+ cityWeatherReport.getId())).build();
//
//    }

}
