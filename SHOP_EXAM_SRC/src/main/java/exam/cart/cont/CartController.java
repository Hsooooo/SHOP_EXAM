package exam.cart.cont;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import exam.cart.service.CartService;
import exam.user.dto.UserDto;

@Controller
@RequestMapping("/cart")
public class CartController {
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping(value="/addCart.do")
	public ModelAndView addCart(HttpServletRequest request, @RequestBody String prdtNo) {
		ModelAndView mv = new ModelAndView("jsonView");
		HttpSession session = request.getSession();
		Map<String, String> paramMap = new HashMap<String, String>();
		Map<Object, Object> map = new HashMap<Object, Object>();
		UserDto userDto = (UserDto)session.getAttribute("userDto");
		log.info("prdtNo >"+ prdtNo);
		String userNo = userDto.getUser_no();
		log.info("userNo>" + userNo);
		
		paramMap.put("userNo", userNo);
		paramMap.put("prdtNo", prdtNo);
		try {
			int cartCnt = cartService.chkCart(paramMap);
			
			if(cartCnt >0) {
				log.info("cartCnt > 0");
				mv.addObject("flag",0);
			}else {
				int cnt = cartService.addCart(paramMap);
				if(cnt > 0) {
					log.info("cnt > 0");
					mv.addObject("flag",1);
					
				}
			}
		}catch(Exception e) {
			log.error("에러 >" + e.getMessage());
			
		}
		
		
		
		return mv;
	}
}
