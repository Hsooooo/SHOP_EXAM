package exam.cart.dao;

import java.util.List;
import java.util.Map;

import exam.cart.dto.CartDto;

public interface CartDao {
	public int chkCart(Map<String, String> paramMap) throws Exception;

	public int addCart(Map<String, String> paramMap) throws Exception;
	
	public List<CartDto> getUserCartList(Map<String, String> paramMap) throws Exception;
	
	public int getUserCartListCnt(Map<String, String> paramMap) throws Exception;
}
