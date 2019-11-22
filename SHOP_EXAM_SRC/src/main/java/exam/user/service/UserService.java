package exam.user.service;

import java.util.List;

import exam.user.dto.UserDto;

public interface UserService {
	public List<UserDto> userList() throws Exception;
}
