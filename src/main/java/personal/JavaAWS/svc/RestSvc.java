package personal.JavaAWS.svc;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import personal.JavaAWS.ExceptionHandler.GlobalExceptionHandler;
import personal.JavaAWS.ExceptionHandler.ErrorResponse;
import personal.JavaAWS.entity.ErrorMessage;
import personal.JavaAWS.entity.WeatherEnt;

@Component
public class RestSvc {
	@Value("${apiKey}")
	private String apiKey;
	@Value(value="http://localhost:8081/error")
	private String errorPage;

	@Autowired
	GlobalExceptionHandler FirstTimeErrorResponse;
	
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
//		} catch (Exception e) {
//			e.printStackTrace();
		}
		return weather;
	}
	public void errorPage(ErrorMessage error) {
		try {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		URI uri = new URI("http://localhost:8080/error");
		HttpEntity<ErrorMessage> httpEntity = new HttpEntity<>(error, headers);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(uri, httpEntity,ErrorMessage.class);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
