package exam.cart.service;

import java.util.Map;

public interface CartService {

	public int chkCart(Map<String, String> paramMap) throws Exception;

	public int addCart(Map<String, String> paramMap) throws Exception;

}
