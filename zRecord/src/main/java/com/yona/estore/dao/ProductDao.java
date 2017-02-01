package com.yona.estore.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.yona.estore.model.Product;

public class ProductDao {

	private List<Product> productList;

	public List<Product> getProductList() {
		
		Product product1 = new Product();
		product1.setProductId(22);
		product1.setProductName("ipod");
		product1.setProductCondition("new");
		product1.setProductCategory("playyers");
		product1.setProductDescription("ipod shuffle");
		product1.setProductManufacturer("USA");
		product1.setProductPrice(200.00);
		product1.setProductStatus("Active");
		product1.setUnitInStock(20);

		Product product2 = new Product();
        product2.setProductId(33);
        product2.setProductName("Record1");
        product2.setProductCategory("Record");
        product2.setProductDescription("This is an awesome mix of 20th century!");
        product2.setProductPrice(25);
        product2.setProductCondition("new");
        product2.setProductStatus("Active");
        product2.setUnitInStock(51);
        product2.setProductManufacturer("EMI");

        Product product3 = new Product();
        product3.setProductId(44);
        product3.setProductName("Speaker1");
        product3.setProductCategory("Accessory");
        product3.setProductDescription("This is a Polk Shelf Speaker!");
        product3.setProductPrice(355);
        product3.setProductCondition("new");
        product3.setProductStatus("Active");
        product3.setUnitInStock(9);
        product3.setProductManufacturer("Polk");

        productList=new ArrayList<Product>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);


        return productList;
	}
	
	public Product getProductById(int Id) throws IOException{
        for (Product product: getProductList()) {
            if(product.getProductId() == Id) {
                return product;
            }
        }

        throw new IOException("No product found.");
    }

}
