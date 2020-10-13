package personal.JavaAWS.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import personal.JavaAWS.entity.ColorsEntity;
import personal.JavaAWS.entity.ErrorMessage;
import personal.JavaAWS.entity.Form;
import personal.JavaAWS.entity.WeatherEnt;
import personal.JavaAWS.svc.ColorsSvc;
import personal.JavaAWS.svc.WeatherAsync;
import personal.JavaAWS.svc.WeatherSync;

@RestController
public class AWSController {


	@Autowired
	ColorsSvc colorsSvc;
	@Autowired
	WeatherAsync weatherAsync;
	@Autowired
	WeatherSync weatherSync;
	
	@RequestMapping("/")
	public ModelAndView index(HttpServletRequest request, Model model, ColorsEntity colorsForm) {
		ModelAndView modelAndView = new ModelAndView();
		if (request.isUserInRole("ADMIN")) {
			model.addAttribute("colorForm", colorsForm);
			modelAndView.setViewName("colorInsert");
			return modelAndView;
		} else if (request.isUserInRole("SUPERADMIN")) {
			model.addAttribute("colorForm", colorsForm);
			modelAndView.setViewName("superAdminPage");
			return modelAndView;
		}
		modelAndView.setViewName("homePage");
		return modelAndView;
	}

	@RequestMapping("/form")
	public ModelAndView output(ColorsEntity colorsForm, Model model) {
		System.out.println(colorsForm);
		colorsSvc.addColor(colorsForm);
		model.addAttribute("form", colorsForm);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("outputPage");
		return modelAndView;
	}
	
	@RequestMapping("/delete")
	public void remove(ColorsEntity colorsForm) {
		colorsSvc.removeColor(colorsForm);
	}
	
	@RequestMapping("/Colors")
	public List<ColorsEntity> allStored() {
		Iterator<ColorsEntity> allColors = colorsSvc.allColors();
		List<ColorsEntity> listColors = new ArrayList<>();
		while (allColors.hasNext()) {
			listColors.add(allColors.next());
		}
		return listColors;
	}
	
	@RequestMapping(value="/Weather/{formString}")
	public @ResponseBody List<WeatherEnt> weatherSvc( @PathVariable(value="formString") String formString){
		ObjectMapper objectMapper = new ObjectMapper();
		Form form = new Form();
		try {
			form = objectMapper.readValue(formString, Form.class);
			System.out.println(form);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		List<WeatherEnt> weatherList = new ArrayList<>();
		System.out.println(form);
		if (form.async==true) {
    		weatherList = weatherAsync.AsyncWeatherCall(form);
    	}
    	else {
    		weatherList = weatherSync.SyncWeatherCall(form);
    	}
		System.out.println("afterForm"+form);
		return weatherList;
	}
	
}
