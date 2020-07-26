package personal.portfolio.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PortfolioController {

	@GetMapping("/")
	public String index(HttpServletRequest request) {
		if (request.isUserInRole("USER")) {
		return "homeiePage";	
		}
		return "homePage";
	}
}
