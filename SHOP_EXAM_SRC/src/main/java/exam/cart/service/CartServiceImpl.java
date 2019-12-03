package exam.cart.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exam.cart.dao.CartDao;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cartDao;
	
	@Override
	public int chkCart(Map<String, String> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return cartDao.chkCart(paramMap);
	}

	@Override
	public int addCart(Map<String, String> paramMap) throws Exception {
		return cartDao.addCart(paramMap);
		
	}

}
