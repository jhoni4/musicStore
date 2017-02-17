package com.yona.estore.service;

import com.yona.estore.model.Cart;

public interface CartService {

	Cart getCartById(int cartId);
	
	void updateCart(Cart cart);

}
