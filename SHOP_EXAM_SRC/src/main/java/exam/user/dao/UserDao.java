package exam.user.dao;

import java.util.List;
import java.util.Map;

import exam.user.dto.UserDto;

public interface UserDao {
	public List<UserDto> userList() throws Exception;

	public int getUserChk(Map<String, String> paramMap) throws Exception;

	public int idCheck(String id) throws Exception;

	public int insertBasicUserInfo(Map<String, String> paramMap) throws Exception;

	public int insertUserAddrInfo(Map<String, String> paramMap) throws Exception;

	public int insertUserAccountInfo(Map<String, String> paramMap) throws Exception;

	public String getUserNo() throws Exception;
}
