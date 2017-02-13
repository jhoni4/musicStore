package com.yona.estore.controller;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yona.estore.dao.ProductDao;
import com.yona.estore.model.Product;


@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ProductDao productDao;

    @RequestMapping("/")
    public String home() {
        return "home";
    }


   
}
