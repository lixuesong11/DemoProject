package com.neusoft.elm.controller;

import javax.servlet.http.HttpServletRequest;

import com.neusoft.elm.po.Cart;
import com.neusoft.elm.service.CartService;
import com.neusoft.elm.service.impl.CartServiceImpl;

public class CartController {
	
	CartService service=new CartServiceImpl();
	
	public Object saveCart(HttpServletRequest request) {
		Cart cart=new Cart();
		cart.setBusinessId(Integer.valueOf(request.getParameter("businessId")));
		cart.setFoodId(Integer.valueOf(request.getParameter("foodId"))	);
	    cart.setUserId(	request.getParameter("userId"));
	    
	    int result=service.saveCart(cart);
	   	return result;
	}
	
	public Object updateCart(HttpServletRequest request) {
		Cart cart=new Cart();
		cart.setBusinessId(Integer.valueOf(request.getParameter("businessId")));
		cart.setFoodId(Integer.valueOf(request.getParameter("foodId"))	);
	    cart.setUserId(	request.getParameter("userId"));
	    cart.setQuantity( Integer.valueOf(request.getParameter("quantity")));
	   
	    int result=service.updateCart(cart);
	   	return result;
	}
	
	public Object removeCart(HttpServletRequest request) {
		Cart cart=new Cart();
		cart.setBusinessId(Integer.valueOf(request.getParameter("businessId")));
		cart.setFoodId(Integer.valueOf(request.getParameter("foodId"))	);
	    cart.setUserId(	request.getParameter("userId"));
	    
	   
	    int result=service.removeCart(cart);
	   	return result;
	}
	
	public Object listCart(HttpServletRequest request) {
		Cart cart=new Cart();
		cart.setBusinessId(Integer.valueOf(request.getParameter("businessId")));
	    cart.setUserId(	request.getParameter("userId"));
	    
	   
	   
	   	return service.listCart(cart);
	}
	
}
