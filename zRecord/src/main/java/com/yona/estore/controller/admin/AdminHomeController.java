package com.yona.estore.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yona.estore.model.Customer;
import com.yona.estore.model.Product;
import com.yona.estore.service.CustomerService;
import com.yona.estore.service.ProductService;


@Controller
@RequestMapping("/admin")
public class AdminHomeController {


    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;
    
    @RequestMapping
    public String adminPage() {
        return "admin";
    }

    @RequestMapping("/productInventory")
    public String productInventory(Model model) {
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);

        return "productInventory";
    }

    @RequestMapping("/customer")
    public String customerManagement(Model model) {

        List<Customer> customerList = customerService.getAllCustomers();
        model.addAttribute("customerList", customerList);

        return "customerManagment";
    }
}