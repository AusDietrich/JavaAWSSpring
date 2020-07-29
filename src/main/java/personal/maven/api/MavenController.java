package personal.maven.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MavenController {

	@GetMapping("/")
	public String landing() {
		return "landingPage";
	}
}
