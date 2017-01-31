package com.yona.estore.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yona.estore.dao.ProductDao;
import com.yona.estore.model.Product;

@Controller
public class HomeController {

	private ProductDao productDao = new ProductDao();

	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/productList")
    public String getProducts(Model model) {
        List<Product> products = productDao.getProductList();
        model.addAttribute("products", products);

        return "productList";
    }
}
