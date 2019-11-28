package exam.shop.service;

import java.util.List;

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
	
	
}
