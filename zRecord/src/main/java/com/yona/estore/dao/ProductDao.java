package com.yona.estore.dao;

import java.util.List;

import com.yona.estore.model.Product;

public interface ProductDao {

	void addProduct(Product product);

    void editProduct(Product product);

    Product getProductById(String id);

    List<Product> getAllProducts();

    void deleteProduct(String id);
}