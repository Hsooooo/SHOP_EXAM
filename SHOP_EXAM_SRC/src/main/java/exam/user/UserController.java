package exam.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import exam.user.dto.UserDto;
import exam.user.service.UserService;

@Controller
public class UserController {
	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/test.do", method = RequestMethod.GET)
	public String test() {

		try {
			List<UserDto> userList = userService.userList();
			for (int i = 0; i < userList.size(); i++) {
				log.info("[user_no : " + userList.get(i).getUser_no() + "][user_name : " + userList.get(i).getUser_name() + "]");
			}
			log.info("----");
		} catch (Exception e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "home";
	}
	
	@RequestMapping(value="/join.do", method= RequestMethod.GET)
	public String join() {
		return "join";
	}
	
}
