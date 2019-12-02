package exam.shop.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import exam.shop.dto.ProductBasicDto;
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

	@Override
	public int getProductListCnt(Map<String, String> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("getProductListCnt", paramMap);
	}

	@Override
	public List<ProductBasicDto> getProductList(Map<String, String> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("getProductList", paramMap);
	}

	@Override
	public List<String> getProductDetailPicList(Map<String, String> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("getProductDetailPicList", paramMap);
	}

	@Override
	public ProductBasicDto getProductDetail(Map<String, String> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("getProductDetail", paramMap);
	}

	
}
