package exam.cart.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exam.cart.dao.CartDao;
import exam.cart.dto.CartDto;

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

	@Override
	public List<CartDto> getUserCartList(Map<String, String> paramMap) throws Exception {
		
		return cartDao.getUserCartList(paramMap);
	}

	@Override
	public int getUserCartListCnt(Map<String, String> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return cartDao.getUserCartListCnt(paramMap);
	}

	@Override
	public int delCart(Map<String, String> paramMap) throws Exception {
		
		return cartDao.delCart(paramMap);
	}
}
