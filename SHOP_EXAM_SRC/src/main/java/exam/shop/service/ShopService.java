package exam.shop.service;

import java.util.List;
import java.util.Map;

import exam.cart.dto.CartDto;
import exam.shop.dto.ProductBasicDto;
import exam.shop.dto.ShopMenuDto;

public interface ShopService {
	/**
	 * 대분류 조회
	 * @return
	 * @throws Exception
	 */
	public List<ShopMenuDto> getBigDivList() throws Exception;
	
	/**
	 * 소분류 조회
	 * @return
	 * @throws Exception
	 */
	public List<ShopMenuDto> getSmallDivList() throws Exception;
	
	public int getProductListCnt(Map<String, String> paramMap) throws Exception;
	
	public List<ProductBasicDto> getProductList(Map<String, String> paramMap) throws Exception;

	public List<String> getProductDetailPicList(Map<String, String> paramMap) throws Exception;

	public ProductBasicDto getProductDetail(Map<String, String> paramMap) throws Exception;
	
	
}
