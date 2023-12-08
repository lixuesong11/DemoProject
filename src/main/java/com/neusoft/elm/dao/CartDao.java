package com.neusoft.elm.dao;

import com.neusoft.elm.po.Cart;

public interface CartDao {

	int saveCart(Cart cart);

	int updateCart(Cart cart);

	int removeCart(Cart cart);

	Object listCart(Cart cart);

	

	

}
