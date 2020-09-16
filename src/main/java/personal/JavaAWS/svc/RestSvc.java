package personal.JavaAWS.svc;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import personal.JavaAWS.entity.WeatherEnt;

@Service
public class RestSvc {
	@Value("${apiKey}")
	private String apiKey;
	
	public WeatherEnt getWeatherInfo(String city) {
		String openWeatherUrl = "http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+apiKey+"&units=imperial";
		WeatherEnt weather = new WeatherEnt();
		ObjectMapper objectMapper = new ObjectMapper();
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<String> response = restTemplate.getForEntity(openWeatherUrl, String.class);
			weather = objectMapper.readValue(response.getBody(), WeatherEnt.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return weather;
	}
}
