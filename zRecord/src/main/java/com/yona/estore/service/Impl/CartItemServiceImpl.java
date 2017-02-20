package com.yona.estore.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yona.estore.dao.CartItemDao;
import com.yona.estore.model.Cart;
import com.yona.estore.model.CartItem;
import com.yona.estore.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	private CartItemDao cartItemDao;
	
	public void addCartItem(CartItem cartItem) {
		cartItemDao.addCartItem(cartItem);

	}

	public void removeCartItem(CartItem cartItem) {
		cartItemDao.removeCartItem(cartItem);

	}

	public void removeAllCartItems(Cart cart) {
		cartItemDao.removeAllCartItems(cart);

	}
	
	public CartItem getCartItemByProductId(int productId) {
		return cartItemDao.getCartItemByProductId(productId);
	}

}
