package com.neusoft.elm.service;

import com.neusoft.elm.po.Cart;

public interface CartService {

	int saveCart(Cart cart);

	int updateCart(Cart cart);

	int removeCart(Cart cart);

	Object listCart(Cart cart);

}
