package exam.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	@RequestMapping(value="/test.do", method=RequestMethod.GET)
	public String test() {
		
		return "home";
	}
}
