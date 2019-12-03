package exam.cart.dao;

import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartDaoImpl implements CartDao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int chkCart(Map<String, String> paramMap) throws Exception {
		
		return sqlSession.selectOne("chkCart", paramMap);
	}

	@Override
	public int addCart(Map<String, String> paramMap) throws Exception {
		return sqlSession.insert("addCart", paramMap);
		
	}

}
