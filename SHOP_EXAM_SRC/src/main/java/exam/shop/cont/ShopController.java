package exam.shop.cont;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@RequestMapping("/exam")
public class ShopController {
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ShopService shopService;
	
	private String pageDiv = "";
	private String currPage = "";
	
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
	
	@RequestMapping("/shopWear.do")
	public String shopWear(HttpServletRequest request, HttpSession session) {
		String param = request.getParameter("param");
		Map<String, String> paramMap = new HashMap<String, String>();
		int pageDiv = 10;
		int currPage = 1;
		log.info("param>>" + param);
		/*
		 * String tmpPageDiv = ("".equals(""+pageDiv) || "0".equals(""+pageDiv))? ""+
		 * 10: ""+pageDiv; String tmpCurrPage = ("".equals(""+currPage) ||
		 * "0".equals(""+currPage))? ""+ "1": ""+currPage; int startRow = (currPage-1)*
		 * pageDiv; paramMap.put("startNum", ""+startRow); paramMap.put("endNum",
		 * ""+(startRow + pageDiv));
		 * 
		 * request.setAttribute("currPage", currPage); request.setAttribute("pageDiv",
		 * pageDiv);
		 */
		//페이징 처리 확인할것
		
		
		return "";
	}
}
