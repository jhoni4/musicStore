package com.yona.estore.dao;

import com.yona.estore.model.Cart;
import com.yona.estore.model.CartItem;

public interface CartItemDao {
	
	void addCartItem(CartItem cartItem);
	
	void removeCartItem(CartItem cartItem);
	
	void removeAllCartItems(Cart cart);

	CartItem getCartItemByProductId(int productId);

}
