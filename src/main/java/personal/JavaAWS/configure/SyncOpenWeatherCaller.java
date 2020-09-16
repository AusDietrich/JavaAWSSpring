package personal.JavaAWS.configure;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import personal.JavaAWS.entity.WeatherEnt;
import personal.JavaAWS.svc.RestSvc;

@Service
public class SyncOpenWeatherCaller {
	@Autowired
	private RestSvc restSvc;

	public WeatherEnt getWeather(String city) {
		WeatherEnt weather = restSvc.getWeatherInfo(city);
		return weather;
	}

	public WeatherEnt getColorTemp(WeatherEnt weather) {
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer temp = weather.getMain().getTemp();
		if (temp <= 0) {
			weather.setRed(Integer.parseInt("0"));
			weather.setBlue(Integer.parseInt("255"));
		} else if (temp >= 100) {
			weather.setRed(Integer.parseInt("255"));
			weather.setBlue(Integer.parseInt("0"));
		} else {
			Integer other = Integer.parseInt("100") - temp;
			double d = other;
			double k = 255 * (d / 100);
			double a = temp;
			double b = 255 * (a / 100);
			temp = (int) Math.round(b);
			other = (int) Math.round(k);
			weather.setBlue(other);
			weather.setRed(temp);
		}
		return weather;
	}
}
