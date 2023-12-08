package com.neusoft.elm.service.impl;

import com.neusoft.elm.dao.CartDao;
import com.neusoft.elm.dao.impl.CartDaoImpl;
import com.neusoft.elm.po.Cart;
import com.neusoft.elm.service.CartService;

public class CartServiceImpl implements CartService {
	CartDao dao=new CartDaoImpl();
	@Override
	public int saveCart(Cart cart) {
		
		return dao.saveCart(cart);
	}
	@Override
	public int updateCart(Cart cart) {
		// TODO Auto-generated method stub
		return dao.updateCart(cart);
	}
	@Override
	public int removeCart(Cart cart) {
		// TODO Auto-generated method stub
		return dao.removeCart(cart);
	}
	@Override
	public Object listCart(Cart cart) {
		// TODO Auto-generated method stub
		return dao.listCart(cart);
	}

}
