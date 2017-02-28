package com.yona.estore.service;

import java.util.List;

import com.yona.estore.model.Customer;
import com.yona.estore.model.Product;

public interface CustomerService {
	void addCustomer (Customer customer);

    Customer getCustomerById (int customerId);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername (String username);
    
	void editCustomer(Customer customer);

	void deleteCustomer(Customer customer);
}
