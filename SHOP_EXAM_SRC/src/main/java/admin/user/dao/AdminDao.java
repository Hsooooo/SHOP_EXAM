package admin.user.dao;

import java.util.Map;

public interface AdminDao {

	public String getPrdtNo() throws Exception;

	public int insertPrdtBasicInfo(Map<String, String> basicPrdMap) throws Exception;

	public int insertPrdPicInfo(Map<String, String> map) throws Exception;
	
}
