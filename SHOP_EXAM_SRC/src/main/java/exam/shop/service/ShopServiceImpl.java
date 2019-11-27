package exam.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exam.shop.dao.ShopDao;
import exam.shop.dto.ShopMenuDto;

@Service
public class ShopServiceImpl implements ShopService {
	@Autowired
	private ShopDao shopDao;

	@Override
	public List<ShopMenuDto> getBigDivList() throws Exception {
		return shopDao.getBigDivList();
	}

	@Override
	public List<ShopMenuDto> getSmallDivList() throws Exception {
		return shopDao.getSmallDivList();
	}
	
	
}
