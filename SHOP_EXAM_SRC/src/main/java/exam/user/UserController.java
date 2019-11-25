package exam.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import exam.common.util.CommonUtil;
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
	
	@RequestMapping(value="/join.do")
	public String join(HttpServletRequest request) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		Map<String, String> paramMap = new HashMap<String, String>();
		try {
			paramMap.put("name", name);
			paramMap.put("email", email);
			log.info(paramMap.toString());
			int cnt = userService.getUserChk(paramMap);
			if(cnt >0) {
				request.setAttribute("result_message", "이미 회원정보가 존재합니다. 로그인해주세요");
				request.setAttribute("result_link", "/exam/login.do");
				return "common/result";
			}else {
				request.setAttribute("name", name);
				request.setAttribute("email", email);
				return  "join";
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			request.setAttribute("result_message", "유저 정보 확인 오류");
			request.setAttribute("result_link", "/exam/login.do");
			return "common/result";
		}
		
	}
	
	@RequestMapping(value="/login.do", method= RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/idChk.do")
	public ModelAndView idChk(@RequestBody String id){
		int count = 0;
		Map<Object, Object> map = new HashMap<Object, Object>();
		ModelAndView mv = new ModelAndView("jsonView");
		try {
			count = userService.idCheck(id);
			mv.addObject("cnt",count);
		}catch(Exception e) {
			log.error(e.getMessage());
			map.put("error", e.getMessage());
		}
		return mv;
		
	}
	
	
	@RequestMapping(value="/userReg.do")
	public String userReg(HttpServletRequest request) {
		Map<String, String> paramMap = new HashMap<String, String>();
		int cnt = 0;
		try {
			paramMap.put("addr",CommonUtil.getString(request.getParameter("addr")));
			paramMap.put("addrDetail",CommonUtil.getString(request.getParameter("addrDetail")));
			paramMap.put("postCode",CommonUtil.getString(request.getParameter("postCode")));
			paramMap.put("name",CommonUtil.getString(request.getParameter("name")));
			paramMap.put("email",CommonUtil.getString(request.getParameter("email")));
			paramMap.put("pwd",CommonUtil.getString(request.getParameter("pwd")));
			paramMap.put("id",CommonUtil.getString(request.getParameter("id")));
			log.info(paramMap.toString());
			cnt = userService.userReg(paramMap);
			if(cnt != 1) {
				throw new Exception("오류");
			}
			
		}catch(Exception e) {
			log.error(e.getMessage());
			request.setAttribute("result_message", "가입중 오류가 발생했습니다.");
			request.setAttribute("result_link", "/exam/join.do");
			return "common/result";
		}
		request.setAttribute("result_message", "회원가입을 축하합니다.");
		request.setAttribute("result_link", "/exam/home.do");
		return "common/result";
	}
	
}
