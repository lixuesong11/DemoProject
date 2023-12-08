package com.neusoft.elm.controller;

import javax.servlet.http.HttpServletRequest;

import com.neusoft.elm.po.User;
import com.neusoft.elm.service.UserService;
import com.neusoft.elm.service.impl.UserServiceImpl;

public class UserController {
	UserService service=new UserServiceImpl();
	public Object getUserById(HttpServletRequest request) {
		String userId=request.getParameter("userId");
	
		return service.getUserById(userId);
	}
	
	public Object getUserByIdBypassword(HttpServletRequest request){
		String userId=request.getParameter("userId");
		String password=request.getParameter("password");
		User user= service.getUserByIdBypassword(userId,password);
		
		
		return user;
	}
	
}