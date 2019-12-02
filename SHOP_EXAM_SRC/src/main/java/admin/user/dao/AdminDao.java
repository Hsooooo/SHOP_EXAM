package admin.user.dao;

import java.util.List;
import java.util.Map;

import admin.user.dto.BrandDto;

public interface AdminDao {

	public String getPrdtNo() throws Exception;

	public int insertPrdtBasicInfo(Map<String, String> basicPrdMap) throws Exception;

	public int insertPrdPicInfo(Map<String, String> map) throws Exception;
	
	public List<BrandDto> getBrandList() throws Exception;
}
