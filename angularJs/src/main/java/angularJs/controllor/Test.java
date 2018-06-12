package angularJs.controllor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mvc")
public class Test {
	@RequestMapping("login")
	public String login() {
		return "login";
	}

}
