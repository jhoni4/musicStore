package com.yona.estore.service;

import com.yona.estore.model.CustomerOrder;

public interface CustomerOrderService {

	void addCustomerOrder(CustomerOrder customerOrder);
	
	double getCustomerOrderGrandTotal(int cartId);

}
