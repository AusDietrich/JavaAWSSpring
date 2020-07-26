package personal.portfolio.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import personal.portfolio.model.BasicForm;
import personal.portfolio.svc.PortfolioSvc;

@Controller
public class PortfolioController {

	@Autowired
	PortfolioSvc portfolioSvc;
	
	@GetMapping("/")
	public String index(HttpServletRequest request, Model model, BasicForm basicForm) {
		if (request.isUserInRole("USER")) {
			model.addAttribute("form", basicForm);
			return "homeiePage";	
		}
		return "homePage";
	}
	
	@PostMapping("/form")
	public String output(BasicForm basicForm, Model model) {
		model.addAttribute("form", basicForm);
		portfolioSvc.repeater(basicForm);
		return "outputPage";
	}
}
