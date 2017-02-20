package com.yona.estore.service;

import java.util.List;

import com.yona.estore.model.Customer;

public interface CustomerService {
	void addCustomer (Customer customer);

    Customer getCustomerById (int customerId);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername (String username);
}
