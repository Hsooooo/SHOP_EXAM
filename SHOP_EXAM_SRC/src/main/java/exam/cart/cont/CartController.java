package exam.cart.cont;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import exam.cart.dto.CartDto;
import exam.cart.service.CartService;
import exam.user.dto.UserDto;

@Controller
@RequestMapping("/cart")
public class CartController {
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private CartService cartService;
	
	/**
	 * 카트 추가(ajax 처리)
	 * @param request
	 * @param prdtNo
	 * @return
	 */
	@RequestMapping(value="/addCart.do")
	public ModelAndView addCart(HttpServletRequest request, @RequestBody Map<String,Object> param) {
		ModelAndView mv = new ModelAndView("jsonView");
		HttpSession session = request.getSession();
		Map<String, String> paramMap = new HashMap<String, String>();
		
		UserDto userDto = (UserDto)session.getAttribute("userDto");
		log.info("prdtNo >"+ param.get("prdtNo"));
		String userNo = userDto.getUser_no();
		log.info("userNo>" + userNo);
		
		paramMap.put("userNo", userNo);
		paramMap.put("prdtNo", (String)param.get("prdtNo"));
		paramMap.put("cartAmt", (String)param.get("amt"));
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
	
	
	/**
	 * 회원 카트 목록
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="cartList.do")
	public String cartList(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> paramMap = new HashMap<String, String>();
		try {
			UserDto dto = (UserDto)request.getSession().getAttribute("userDto");
			if(dto == null) {
				log.info("dto null");
				return "redirect:/exam/login.do";
			}
			paramMap.put("userNo",dto.getUser_no());
			int cnt = cartService.getUserCartListCnt(paramMap);
			if(cnt > 0) {
				List<CartDto> cartList = cartService.getUserCartList(paramMap);
				request.setAttribute("cartList", cartList);
			}
			request.setAttribute("cartListCnt", cnt);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		
		return "cart";
	}
	
	@RequestMapping(value="delCart.do")
	public String delCart(HttpServletRequest request) {
		Map<String, String> paramMap = new HashMap<String, String>();
		String prdtNo = request.getParameter("prdtNo");
		try {
			paramMap.put("prdtNo",prdtNo);
			int cnt = cartService.delCart(paramMap);
		}catch(Exception e) {
			
		}
		
		return "redirect:/cart/cartList.do";
	}
	
	@RequestMapping(value="checkoutView.do")
	public String checkoutView() {
		return "checkout";
	}
}
