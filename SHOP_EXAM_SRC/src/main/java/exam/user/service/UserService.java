package exam.user.service;

import java.util.List;
import java.util.Map;

import exam.user.dto.UserDto;

public interface UserService {
	public List<UserDto> userList() throws Exception;

	public int getUserChk(Map<String, String> paramMap) throws Exception;

	public int idCheck(String id) throws Exception;

	public int userReg(Map<String, String> paramMap) throws Exception;
}
