package com.neusoft.elm.service;

import com.neusoft.elm.po.User;

public interface UserService {
	User getUserById(String userId);

	User getUserByIdBypassword(String userId, String password);
}
