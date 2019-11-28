package admin.user.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import admin.user.dao.AdminDao;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;
	
	@Override
	public String getPrdtNo() throws Exception {
		
		return adminDao.getPrdtNo();
	}

	@Override
	@Transactional
	public void insertPrdt(Map<String, String> basicPrdMap, List<Map<String, String>> picListMap) throws Exception {
		int basicCnt = adminDao.insertPrdtBasicInfo(basicPrdMap);
		
		for(int i=0; i< picListMap.size(); i++) {
			if(i==0) {
				picListMap.get(i).put("pic_main_flag", "1");
			}else {
				picListMap.get(i).put("pic_main_flag", "0");
			}
			adminDao.insertPrdPicInfo(picListMap.get(i));
		}
		
	}

}
