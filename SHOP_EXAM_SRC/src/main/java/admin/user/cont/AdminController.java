package admin.user.cont;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import admin.user.service.AdminService;
import exam.shop.dao.ShopDao;
import exam.shop.dto.ShopMenuDto;
import exam.shop.service.ShopService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private Logger log = LoggerFactory.getLogger(getClass());
	
	//home Dir
	private final String imgPath = "C:\\git_workspace\\git\\SHOP_EXAM\\SHOP_EXAM_SRC\\src\\main\\resources\\img";
	//comp Dir
	//private final String imgPath = "C:\\exam_git\\SHOP_EXAM\\SHOP_EXAM_SRC\\src\\main\\resources\\img";
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/main.do")
	public String adminMain() {
		return "admin/adminMain";
	}
	
	@RequestMapping("/regProduct.do")
	public String regProduct(HttpServletRequest request) throws Exception{
		try {
			List<ShopMenuDto> bigDivList = shopService.getBigDivList();
			List<ShopMenuDto> smlDivList = shopService.getSmallDivList();
			
			request.setAttribute("bigDivList", bigDivList);
			request.setAttribute("smlDivList", smlDivList);
		}catch (Exception e) {
			
		}
		return "admin/regProduct";
	}
	
	@RequestMapping("/regProductAf.do")
	public String regProductAf(HttpServletRequest request, HttpServletResponse response) {
		
		log.info("path >>" + imgPath);
		try {
			Map<String, String> basicPrdMap = new HashMap<String, String>();
			
			String prdt_name 	= (String)request.getParameter("prdt_name");
			String prdt_warn 	= (String)request.getParameter("prdt_warn");
			String prdt_amt 	= (String)request.getParameter("prdt_amt");
			String prdt_price	= (String)request.getParameter("prdt_price");
			String prdt_type 	= (String)request.getParameter("prdt_type");
			String bDivCode 	= (String)request.getParameter("bDivCode");
			String sDivCode 	= (String)request.getParameter("sDivCode");
			
			//파라미터 세팅
			basicPrdMap.put("prdt_name",	prdt_name);
			basicPrdMap.put("prdt_warn",	prdt_warn);
			basicPrdMap.put("prdt_amt",		prdt_amt);
			basicPrdMap.put("prdt_price",	prdt_price);
			basicPrdMap.put("prdt_type",	prdt_type);
			basicPrdMap.put("bDiv_code",	bDivCode);
			basicPrdMap.put("sDiv_code",	sDivCode);
			//임시
			basicPrdMap.put("prdt_brand",	"나이키");
			
			MultipartHttpServletRequest multiReq = (MultipartHttpServletRequest) request;
			Iterator<String> iter = multiReq.getFileNames();
			MultipartFile mFile = null;
			String fieldName = "";
			
			
			
			File dir = new File(imgPath);
			if(!dir.isDirectory()) {
				dir.mkdir();
			}
			Map<String, Object> file = new HashMap<String, Object>();
			
			
			List<Map<String, String>> picListMap = new ArrayList<Map<String, String>>();
			
			//제품 번호 생성 Algorithm
			String tmpNo = String.format("%07d",Integer.parseInt(adminService.getPrdtNo()));
			String prdtNo = bDivCode + sDivCode + tmpNo;
			log.info("[Product Number]>>"+ prdtNo);
			
			while(iter.hasNext()) {
				fieldName = (String) iter.next();
				mFile = multiReq.getFile(fieldName);
				if(mFile.isEmpty() == false) {
					log.info("[Field Name]>>" + fieldName);
					String originName;
					originName = new String(mFile.getOriginalFilename().getBytes("8859_1"), "UTF-8");
					
					log.info("[Origin Name]>>" +originName);
					if("".equals(originName)){
						continue;
					}
					String ext = originName.substring(originName.lastIndexOf('.'));
					String saveFileName = getUuid() + ext;
					
					log.info("[Save File Name]>>" + saveFileName);
					File serverFile = new File(imgPath + File.separator + saveFileName);
					mFile.transferTo(serverFile);
					
					file.put("origin Name", originName);
					file.put("serverFile", serverFile);
					String serverPath = "http://localhost:8080/img/";
					String realPath = serverPath + saveFileName;
					if(fieldName.contains("prdt_desc")) {
						log.info("###############설명 사진 ON###############");
						basicPrdMap.put("prdt_desc_pic",realPath);
					}else {
						Map<String, String> picMap = new HashMap<String, String>();
						log.info("###############제품 사진 ON###############");
						picMap.put("pic_path",realPath);
						picMap.put("prdt_no",prdtNo);
						picListMap.add(picMap);
					}
					
				}
			}
			
			
			basicPrdMap.put("prdt_no", prdtNo);
			adminService.insertPrdt(basicPrdMap, picListMap);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	
	public static String getUuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	
	
	
}
