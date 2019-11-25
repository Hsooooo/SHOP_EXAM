package exam.user.dao;

import java.util.List;
import java.util.Map;

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

	@Override
	public int getUserChk(Map<String, String> paramMap) throws Exception {
		
		return (Integer)sqlSession.selectOne("getUserChk", paramMap);
	}

	@Override
	public int idCheck(String id) throws Exception {
		return (Integer)sqlSession.selectOne("idCheck", id);
	}

	@Override
	public int insertBasicUserInfo(Map<String, String> paramMap) throws Exception {
		return sqlSession.insert("insertBasicUserInfo", paramMap);
	}

	@Override
	public int insertUserAddrInfo(Map<String, String> paramMap) throws Exception {
		return sqlSession.insert("insertUserAddrInfo", paramMap);
	}

	@Override
	public int insertUserAccountInfo(Map<String, String> paramMap) throws Exception {
		return sqlSession.insert("insertUserAccountInfo", paramMap);
	}

	@Override
	public String getUserNo() throws Exception {
		return (String)sqlSession.selectOne("getUserNo");
	}

	
	

}
