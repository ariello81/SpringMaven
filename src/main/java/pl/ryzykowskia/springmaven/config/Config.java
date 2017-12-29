package pl.ryzykowskia.springmaven.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import pl.ryzykowskia.springmaven.client.WeatherClient;
import pl.ryzykowskia.springmaven.dao.CsvPacketDao;
import pl.ryzykowskia.springmaven.service.PacketService;

@Configuration
@ComponentScan (basePackageClasses={PacketService.class, CsvPacketDao.class})
@PropertySource("classpath:properties")
public class Config {
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
	    	return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("pl.ryzykowskia.springmaven.ws");
		return marshaller;
	}

	@Bean
	public WeatherClient weatherClient(Jaxb2Marshaller marshaller) {
		WeatherClient client = new WeatherClient();
		client.setDefaultUri("http://www.webservicex.com/globalweather.asmx");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}
