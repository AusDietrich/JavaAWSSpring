package personal.JavaAWS.svc;

import java.util.List;

import org.springframework.stereotype.Service;

import personal.JavaAWS.entity.Form;
import personal.JavaAWS.entity.WeatherEnt;

public interface WeatherAsync {

	public List<WeatherEnt> AsyncWeatherCall(Form form);
}
