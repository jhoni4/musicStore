package com.yona.estore.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yona.estore.dao.CustomerDao;
import com.yona.estore.model.Customer;
import com.yona.estore.model.Product;
import com.yona.estore.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
    private CustomerDao customerDao;

    public void addCustomer (Customer customer) {
        customerDao.addCustomer(customer);
    }

    public Customer getCustomerById(int customerId) {
        return customerDao.getCustomerById(customerId);
    }

    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    public Customer getCustomerByUsername (String username) {
        return customerDao.getCustomerByUsername(username);
    }

	public void editCustomer(Customer customer) {
		customerDao.editCustomer(customer);
		
	}

	public void deleteCustomer(Customer customer) {
		customerDao.deleteCustomer(customer);
		
	}

	

}
