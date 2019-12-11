package exam.cart.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import exam.cart.dto.CartDto;

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
	
	@Override
	public List<CartDto> getUserCartList(Map<String, String> paramMap) throws Exception {
		
		return sqlSession.selectList("getUserCartList", paramMap);
	}

	@Override
	public int getUserCartListCnt(Map<String, String> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("getUserCartListCnt",paramMap);
	}

	@Override
	public int delCart(Map<String, String> paramMap) throws Exception {
		
		return sqlSession.delete("delCart", paramMap);
	}

}
