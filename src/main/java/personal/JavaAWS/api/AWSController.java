package personal.JavaAWS.api;

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

import personal.JavaAWS.entity.User;
import personal.JavaAWS.model.BasicForm;
import personal.JavaAWS.repo.UserRepo;
import personal.JavaAWS.svc.PortfolioSvc;

@RestController
public class AWSController {

	@Autowired
	UserRepo repo;
	@Autowired
	PortfolioSvc portfolioSvc;
	
	@RequestMapping("/")
	public ModelAndView index(HttpServletRequest request, Model model, BasicForm basicForm) {
		ModelAndView modelAndView = new ModelAndView();
		if (request.isUserInRole("USER")) {
			model.addAttribute("form", basicForm);
		    modelAndView.setViewName("homeiePage");
			return modelAndView;	
		}
	    modelAndView.setViewName("homePage");
		return modelAndView;
	}
	@RequestMapping("/form")
	public ModelAndView output(BasicForm basicForm, Model model) {
		model.addAttribute("form", basicForm);
		portfolioSvc.repeater(basicForm);
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("outputPage");
	    return modelAndView;
	}
	
	@RequestMapping("/RDS")
	public ModelAndView AWSRDS(Model model) {
		User user = repo.findUsers();
		System.out.println(user);
		model.addAttribute("user", user);
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("RDS");
	    return modelAndView;
	}
}
