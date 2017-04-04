package com.yona.estore.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yona.estore.model.Customer;
import com.yona.estore.service.CustomerService;

@Controller
@RequestMapping("/admin")
public class AdminCustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/viewCustomer/{customerId}")
	public String viewCustomerDetail(@PathVariable int customerId, Model model){
		Customer customer = customerService.getCustomerById(customerId);
		model.addAttribute("customer", customer);
		
		return "customerDetail";
		
	}

}
