package personal.JavaAWS.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import personal.JavaAWS.entity.ColorsEntity;
import personal.JavaAWS.svc.PortfolioSvc;

@RestController
public class AWSController {


	@Autowired
	PortfolioSvc portfolioSvc;

	@RequestMapping("/")
	public ModelAndView index(HttpServletRequest request, Model model, ColorsEntity colorsForm) {
		ModelAndView modelAndView = new ModelAndView();
		if (request.isUserInRole("USER")) {
			model.addAttribute("colorForm", colorsForm);
			modelAndView.setViewName("colorInsert");
			return modelAndView;
		}
		modelAndView.setViewName("homePage");
		return modelAndView;
	}

	@RequestMapping("/form")
	public ModelAndView output(ColorsEntity colorsForm, Model model) {
		System.out.println(colorsForm);
		portfolioSvc.addColor(colorsForm);
		model.addAttribute("form", colorsForm);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("outputPage");
		return modelAndView;
	}
	@RequestMapping("/delete")
	public void remove(ColorsEntity colorsForm) {
		portfolioSvc.removeColor(colorsForm);
	}
	@RequestMapping("/Colors")
	public List<ColorsEntity> AllStored() {
		Iterator<ColorsEntity> allColors = portfolioSvc.allColors();
		List<ColorsEntity> listColors = new ArrayList<>();
		while (allColors.hasNext()) {
			listColors.add(allColors.next());
		}
		return listColors;
	}
}
