package personal.JavaAWS.svc;

import java.util.List;

import org.springframework.stereotype.Service;

import personal.JavaAWS.entity.Form;
import personal.JavaAWS.entity.WeatherEnt;

public interface WeatherSync {

	public List<WeatherEnt> SyncWeatherCall(Form form);
}
