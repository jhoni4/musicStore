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
	
	@Override
	public void addCartItem(CartItem cartItem) {
		cartItemDao.addCartItem(cartItem);

	}

	@Override
	public void removeCartItem(CartItem cartItem) {
		cartItemDao.removeCartItem(cartItem);

	}

	@Override
	public void removeAllCartItems(Cart cart) {
		cartItemDao.removeAllCartItems(cart);

	}
	
	@Override
	public CartItem getCartItemByProductId(int productId) {
		return cartItemDao.getCartItemByProductId(productId);
	}

}
