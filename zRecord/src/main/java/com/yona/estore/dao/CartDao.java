package com.yona.estore.dao;

import com.yona.estore.model.Cart;

public interface CartDao {

	Cart getCartById(int cartId);

	void update(Cart cart);
}
