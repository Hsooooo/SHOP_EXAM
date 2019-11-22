package exam.user.dao;

import java.util.List;

import exam.user.dto.UserDto;

public interface UserDao {
	public List<UserDto> userList() throws Exception;
}
