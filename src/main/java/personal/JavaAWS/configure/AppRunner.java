package personal.JavaAWS.configure;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import personal.JavaAWS.entity.Form;
import personal.JavaAWS.entity.WeatherEnt;

@Component
public class AppRunner implements CommandLineRunner {

	 private final AsyncOpenWeatherCaller weatherCaller;
	  
	 public AppRunner(AsyncOpenWeatherCaller weatherCaller) {
		    this.weatherCaller = weatherCaller;
		  }
	 
	@Override
	public void run(String... args) throws Exception {
	}
	
	public List<WeatherEnt> runNotRun(Form form) throws Exception {
		List<WeatherEnt> listWeather = new ArrayList<>();
		CompletableFuture<WeatherEnt> stop1=weatherCaller.getWeather(form.getCity1());
		CompletableFuture<WeatherEnt> stop2=weatherCaller.getWeather(form.getCity2());
		CompletableFuture<WeatherEnt> stop3=weatherCaller.getWeather(form.getCity3());
		CompletableFuture<WeatherEnt> stop4=weatherCaller.getWeather(form.getCity4());
		CompletableFuture<WeatherEnt> stop5=weatherCaller.getWeather(form.getCity5());
		CompletableFuture<WeatherEnt> stop6=weatherCaller.getWeather(form.getCity6());
		CompletableFuture.allOf(stop1,stop2,stop3,stop4,stop5,stop6).join();
		stop1 = weatherCaller.getColorTemp(stop1.get());
		stop2 = weatherCaller.getColorTemp(stop2.get());
		stop3 = weatherCaller.getColorTemp(stop3.get());
		stop4 = weatherCaller.getColorTemp(stop4.get());
		stop5 = weatherCaller.getColorTemp(stop5.get());
		stop6 = weatherCaller.getColorTemp(stop6.get());
		CompletableFuture.allOf(stop1,stop2,stop3,stop4,stop5,stop6).join();
		listWeather.add(stop1.get());
		listWeather.add(stop2.get());
		listWeather.add(stop3.get());
		listWeather.add(stop4.get());
		listWeather.add(stop5.get());
		listWeather.add(stop6.get());
		return listWeather;
	}

}
