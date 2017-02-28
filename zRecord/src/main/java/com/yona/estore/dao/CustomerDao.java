package com.yona.estore.dao;

import java.util.List;

import com.yona.estore.model.Customer;
import com.yona.estore.model.Product;

public interface CustomerDao {
	
	void addCustomer (Customer customer);

    Customer getCustomerById (int customerId);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername (String username);
    
	void editCustomer(Customer customer);

	void deleteCustomer(Customer customer);


}
