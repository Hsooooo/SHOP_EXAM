package exam.cart.service;

import java.util.List;
import java.util.Map;

import exam.cart.dto.CartDto;

public interface CartService {

	public int chkCart(Map<String, String> paramMap) throws Exception;

	public int addCart(Map<String, String> paramMap) throws Exception;
	
	public List<CartDto> getUserCartList(Map<String, String> paramMap) throws Exception;
	
	public int getUserCartListCnt(Map<String, String> paramMap) throws Exception;

	public int delCart(Map<String, String> paramMap) throws Exception;

}
