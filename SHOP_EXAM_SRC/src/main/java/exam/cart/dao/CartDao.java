package exam.cart.dao;

import java.util.List;
import java.util.Map;

import exam.cart.dto.CartDto;

public interface CartDao {
	
	/** 
	 * 카트 중복 여부 체크
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int chkCart(Map<String, String> paramMap) throws Exception;

	/**
	 * 장바구니 담기
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int addCart(Map<String, String> paramMap) throws Exception;
	
	/**
	 * 회원 카트 리스트
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<CartDto> getUserCartList(Map<String, String> paramMap) throws Exception;
	
	/**
	 * 회원 카트 리스트 개수
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int getUserCartListCnt(Map<String, String> paramMap) throws Exception;
	
	public int delCart(Map<String, String> paramMap) throws Exception;
}
