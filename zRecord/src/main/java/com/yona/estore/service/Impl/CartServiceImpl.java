package com.yona.estore.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yona.estore.dao.CartDao;
import com.yona.estore.model.Cart;
import com.yona.estore.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	

	@Autowired
	private CartDao cartDao;

	public Cart getCartById(int cartId) {

		return cartDao.getCartById(cartId);
	}

	public void updateCart(Cart cart) {
		cartDao.updateCart(cart);
	}

}
