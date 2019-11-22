package exam.user.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import exam.user.dto.UserDto;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<UserDto> userList() throws Exception {
		return sqlSession.selectList("userList");
	}
	

}
