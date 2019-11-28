package exam.shop.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import exam.shop.dto.ShopMenuDto;

@Repository
public class ShopDaoImpl implements ShopDao {

	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public List<ShopMenuDto> getBigDivList() throws Exception {
		return sqlSession.selectList("getBigDivList");
	}

	@Override
	public List<ShopMenuDto> getSmallDivList() throws Exception {
		
		return sqlSession.selectList("getSmallDivList");
	}

	
}
