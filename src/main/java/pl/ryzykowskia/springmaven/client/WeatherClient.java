package pl.ryzykowskia.springmaven.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import pl.ryzykowskia.springmaven.ws.GetCitiesByCountry;
import pl.ryzykowskia.springmaven.ws.GetCitiesByCountryResponse;
import pl.ryzykowskia.springmaven.ws.GetWeather;
import pl.ryzykowskia.springmaven.ws.GetWeatherResponse;

public class WeatherClient extends WebServiceGatewaySupport {


	public GetCitiesByCountryResponse getCitiesByCountry(String country) {
		GetCitiesByCountry request = new GetCitiesByCountry();
		request.setCountryName(country);

		GetCitiesByCountryResponse response = (GetCitiesByCountryResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://www.webservicex.com/globalweather.asmx",
						request, new SoapActionCallback("http://www.webserviceX.NET/GetCitiesByCountry"));

		return response;
	}

	
	public GetWeatherResponse getWeather(String country, String city) {
		GetWeather request = new GetWeather();
		request.setCountryName(country);
		request.setCityName(city);

		GetWeatherResponse response = (GetWeatherResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://www.webservicex.com/globalweather.asmx",
						request, new SoapActionCallback("http://www.webserviceX.NET/GetWeather"));

		return response;
	}
	
	
	
}