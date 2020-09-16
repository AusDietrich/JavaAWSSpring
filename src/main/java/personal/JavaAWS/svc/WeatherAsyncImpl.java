package personal.JavaAWS.svc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import personal.JavaAWS.configure.AppRunner;
import personal.JavaAWS.configure.AsyncOpenWeatherCaller;
import personal.JavaAWS.entity.Form;
import personal.JavaAWS.entity.WeatherEnt;

@Service
public class WeatherAsyncImpl implements WeatherAsync{

	@Autowired
	AsyncOpenWeatherCaller weatherCaller;
	@Override
	public List<WeatherEnt> AsyncWeatherCall(Form form) {
		List<WeatherEnt> listWeather = new ArrayList<>();
		System.out.println("Async");
		AppRunner apprun = new AppRunner(weatherCaller);
        try {
        	listWeather = apprun.runNotRun(form);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return listWeather;
	}

}
