package pl.ryzykowskia.springmaven.start;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.ryzykowskia.springmaven.client.WeatherClient;
import pl.ryzykowskia.springmaven.config.Config;
import pl.ryzykowskia.springmaven.model.Packet;
import pl.ryzykowskia.springmaven.service.PacketService;
import pl.ryzykowskia.springmaven.ws.GetCitiesByCountry;
import pl.ryzykowskia.springmaven.ws.GetCitiesByCountryResponse;
import pl.ryzykowskia.springmaven.ws.GetWeatherResponse;



public class Main {
	
    public static void main(String[] args) throws Exception {
      //  ApplicationContext appCtx = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        ApplicationContext appCtx = new AnnotationConfigApplicationContext(Config.class);
        
        WeatherClient weatherClient = 
            	(WeatherClient)appCtx.getBean("weatherClient");
        
        GetCitiesByCountryResponse response1 = weatherClient.getCitiesByCountry("Poland");
        System.out.println(response1.getGetCitiesByCountryResult());
        
        GetWeatherResponse response2 = weatherClient.getWeather("Poland", "Krakow");
        System.out.println(response2.getGetWeatherResult());
        
/*        PacketService packetService = 
        	(PacketService)appCtx.getBean("packetService");
        
        List<Packet> foundPackets = packetService.getPacketsFromPostCodeFamily();

        for (Packet packet : foundPackets) {
            System.out.println(packet);
        }
        System.out.println(foundPackets.size());*/
        
        
    }
}