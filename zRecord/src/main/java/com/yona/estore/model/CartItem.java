package com.yona.estore.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.GeneratedValue;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CartItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5585071882593886789L;

	@Id
	@GeneratedValue
	private int cartItemId;

	@ManyToOne
	@JoinColumn(name = "cartId")
	@JsonIgnore
	private Cart cart;

	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;

	private int quantity;
	private double totalPrice;

	public int getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
