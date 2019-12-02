package admin.user.service;

import java.util.List;
import java.util.Map;

import admin.user.dto.BrandDto;

public interface AdminService {

	public String getPrdtNo() throws Exception;

	public void insertPrdt(Map<String, String> basicPrdMap, List<Map<String, String>> picListMap) throws Exception;

	public List<BrandDto> getBrandList() throws Exception;
}
