package exam.user.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import exam.user.dao.UserDao;
import exam.user.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<UserDto> userList() throws Exception {
		
		return userDao.userList();
	}

	@Override
	public int getUserChk(Map<String, String> paramMap) throws Exception {
		
		return userDao.getUserChk(paramMap);
	}

	@Override
	public int idCheck(String id) throws Exception {
		return userDao.idCheck(id);
	}

	@Override
	@Transactional
	public int userReg(Map<String, String> paramMap) throws Exception {
		String userNo = userDao.getUserNo();
		paramMap.put("userNo", userNo);
		int returnCnt = 0;
		int basicCnt = userDao.insertBasicUserInfo(paramMap);
		if(basicCnt >0) {
			int acctCnt = userDao.insertUserAccountInfo(paramMap);
			if(acctCnt >0) {
				int addrCnt = userDao.insertUserAddrInfo(paramMap);
				if(addrCnt >0) {
					returnCnt = 1;
				}
			}
		}
		return returnCnt;
		
	}

	@Override
	public String chkPw(Map<String, String> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return userDao.chkPw(paramMap);
	}

	@Override
	public UserDto getUserInfo(Map<String, String> paramMap) throws Exception {
		return userDao.getUserInfo(paramMap);
	}

}
