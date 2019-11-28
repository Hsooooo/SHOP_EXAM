package admin.user.dao;

import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public String getPrdtNo() throws Exception {
		
		return sqlSession.selectOne("getPrdtNo");
	}

	@Override
	public int insertPrdtBasicInfo(Map<String, String> basicPrdMap) throws Exception {
		
		return sqlSession.insert("insertPrdtBasicInfo", basicPrdMap);
	}

	@Override
	public int insertPrdPicInfo(Map<String, String> map) throws Exception {
		
		return sqlSession.insert("insertPrdPicInfo", map);
	}

}
