package personal.JavaAWS.svc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import personal.JavaAWS.configure.SyncOpenWeatherCaller;
import personal.JavaAWS.entity.Form;
import personal.JavaAWS.entity.WeatherEnt;

@Service
public class WeatherSyncImpl implements WeatherSync{

	@Autowired
	SyncOpenWeatherCaller timeKillerSync;
	
	@Override
	public List<WeatherEnt> SyncWeatherCall(Form form) {
		List<WeatherEnt> weatherList = new ArrayList<>();
		System.out.println("Sync");
		WeatherEnt stop1=timeKillerSync.getWeather(form.getCity1());
		weatherList.add(stop1);
		WeatherEnt stop2=timeKillerSync.getWeather(form.getCity2());
		weatherList.add(stop2);
		WeatherEnt stop3=timeKillerSync.getWeather(form.getCity3());
		weatherList.add(stop3);
		WeatherEnt stop4=timeKillerSync.getWeather(form.getCity4());
		weatherList.add(stop4);
		WeatherEnt stop5=timeKillerSync.getWeather(form.getCity5());
		weatherList.add(stop5);
		WeatherEnt stop6=timeKillerSync.getWeather(form.getCity6());
		weatherList.add(stop6);
		for(int i=0;i<weatherList.size();i++) {
			weatherList.set(i, timeKillerSync.getColorTemp(weatherList.get(i)));
		}
		return weatherList;
	}

}
