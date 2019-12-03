package exam.shop.cont;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import exam.common.util.Pagination;
import exam.shop.dto.ProductBasicDto;
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
	
	@RequestMapping(value="/shopWear.do", method=RequestMethod.GET)
	public String shopWear(HttpServletRequest request, HttpSession session,@ModelAttribute("pageMaker") Pagination pageMaker) {
		String param = request.getParameter("param");
		Map<String, String> paramMap = new HashMap<String, String>();
		String currPageTmp = StringUtils.defaultIfEmpty(request.getParameter("currPage"), "");
		
		if("".equals(currPageTmp)) {
			currPageTmp = "0";
		}
		int pageDiv = 10;
		int currPage = Integer.parseInt(currPageTmp);
		int pageBegin=(currPage-1)* pageDiv+1;
		int pageEnd=pageBegin + pageDiv-1;
		log.info("param>>" + param);
		
		log.info("param>>" + paramMap.toString());
		
		paramMap.put("param", param);
		try {
			pageMaker.setTotPage(shopService.getProductListCnt(paramMap));
			paramMap.put("pageBegin", ""+pageMaker.getPageBegin());
			paramMap.put("pageEnd", ""+pageMaker.getPageEnd());
			List<ProductBasicDto> productList = shopService.getProductList(paramMap);
			List<ShopMenuDto> bigDivMenuList = shopService.getBigDivList();
			List<ShopMenuDto> smlDivMenuList = shopService.getSmallDivList();
			int totCount = pageMaker.getTotPage();
			request.setAttribute("bigDivList", bigDivMenuList);
			request.setAttribute("smlDivList", smlDivMenuList);
			request.setAttribute("productList", productList);
			request.setAttribute("productListCnt", totCount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "shopWear";
	}
	
	@RequestMapping(value="productDetail.do", method=RequestMethod.GET)
	public String productDetail(HttpServletRequest request) {
		String prdtNo = request.getParameter("prdtNo");
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("prdtNo",prdtNo);
		try {
			List<ShopMenuDto> bigDivMenuList = shopService.getBigDivList();
			List<ShopMenuDto> smlDivMenuList = shopService.getSmallDivList();
			
			request.setAttribute("bigDivList", bigDivMenuList);
			request.setAttribute("smlDivList", smlDivMenuList);
			List<String> picList = shopService.getProductDetailPicList(paramMap);
			ProductBasicDto productDto = shopService.getProductDetail(paramMap);
			request.setAttribute("picList", picList);
			request.setAttribute("productDto", productDto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "productDetail";
	}
	
	
}
