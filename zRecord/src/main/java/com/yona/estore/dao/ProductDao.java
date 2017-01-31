package com.yona.estore.dao;

import java.util.ArrayList;
import java.util.List;

import com.yona.estore.model.Product;

public class ProductDao {

	private List<Product> productList;

	public List<Product> getProductList() {
		Product product1 = new Product();

		product1.setProductName("ipod");
		product1.setProductCondition("new");
		product1.setProductCategory("playyers");
		product1.setProductDescription("ipod shuffle");
		product1.setProductManufacturer("USA");
		product1.setProductPrice(200.00);
		product1.setProductStatus("Active");
		product1.setUnitInStock(20);

		productList = new ArrayList<Product>();
		productList.add(product1);

		return productList;
	}

}
