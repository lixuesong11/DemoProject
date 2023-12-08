package com.neusoft.elm.service.impl;

import com.neusoft.elm.dao.UserDao;
import com.neusoft.elm.dao.impl.UserDaoImpl;
import com.neusoft.elm.po.User;
import com.neusoft.elm.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao dao =new UserDaoImpl();
	@Override
	public User getUserById(String userId) {
		return dao.getUserById(userId);
	}
	@Override
	public User getUserByIdBypassword(String userId, String password) {
		
		return dao.getUserByIdBypassword(userId,password);
	}

}
