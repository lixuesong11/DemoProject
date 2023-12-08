package com.neusoft.elm.dao;

import com.neusoft.elm.po.User;

public interface UserDao {
	User getUserById(String userId);

	User getUserByIdBypassword(String userId, String password);
}
