package exam.shop.cont;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import exam.shop.dto.ShopMenuDto;
import exam.shop.service.ShopService;

@Controller
public class ShopController {
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ShopService shopService;
	
	
	@RequestMapping(value="/shop.do")
	public String shop(HttpServletRequest request, HttpSession session) {
		try {
			List<ShopMenuDto> bigDivMenuList = shopService.getBigDivList();
			List<ShopMenuDto> smlDivMenuList = shopService.getSmallDivList();
			
			request.setAttribute("bigDivList", bigDivMenuList);
			request.setAttribute("smlDivList", smlDivMenuList);
		}catch(Exception e) {
			
		}
		return "shop";
	}
}
