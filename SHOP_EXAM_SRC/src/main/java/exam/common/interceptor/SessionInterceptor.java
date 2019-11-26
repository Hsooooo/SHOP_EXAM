package exam.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import exam.user.dto.UserDto;

public class SessionInterceptor extends HandlerInterceptorAdapter {
	private Logger log = LoggerFactory.getLogger(getClass());
	static final String[] EXCLUDE_URL_LIST = {
			"/exam/home.do"
	};
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String reqUrl = request.getRequestURI().toString();
		for(String target : EXCLUDE_URL_LIST) {
			if(reqUrl.indexOf(target) > -1) {
				return true;
			}
		}
		
		HttpSession session = request.getSession();
		UserDto userDto = (UserDto)session.getAttribute("userDto");
		
		/*
		 * if(userDto == null) { log.info(">>Interceptor Catch [userDto is null]");
		 * session.invalidate(); response.sendRedirect(request.getContextPath() +
		 * "/login.do"); return false; }
		 */
		return true;
	}

	
	

}
