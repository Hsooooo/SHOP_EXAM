package exam.cart.dao;

import java.util.Map;

public interface CartDao {
	public int chkCart(Map<String, String> paramMap) throws Exception;

	public int addCart(Map<String, String> paramMap) throws Exception;
}
