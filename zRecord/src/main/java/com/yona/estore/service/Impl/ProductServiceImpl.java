package com.yona.estore.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yona.estore.dao.ProductDao;
import com.yona.estore.model.Product;
import com.yona.estore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    public Product getProductById (int productId) {
        return productDao.getProductById(productId);
    }

    public List<Product> getProductList () {
        return productDao.getProductList();
    }

    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    public void editProduct(Product product) {
        productDao.editProduct(product);
    }

    public void deleteProduct(Product product) {
        productDao.deleteProduct(product);
    }
}

