package com.yona.estore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.yona.estore.model.Cart;
import com.yona.estore.model.CartItem;
import com.yona.estore.model.Customer;
import com.yona.estore.model.Product;
import com.yona.estore.service.CartItemService;
import com.yona.estore.service.CartService;
import com.yona.estore.service.CustomerService;
import com.yona.estore.service.ProductService;

@Controller
@RequestMapping("/rest/cart")
public class CartResource {

	@Autowired
	private CartService cartService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ProductService productService;

	@Autowired
	private CartItemService cartItemService;

	@RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
	public @ResponseBody Cart getCartById(@PathVariable(value = "cartId") int cartId) {
		return cartService.getCartById(cartId);
	}

	@RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addItem(@PathVariable(value = "productId") int productId, @AuthenticationPrincipal User activeUser) {
		Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
		// since customer to cart is one-to-one r/s
		Cart cart = customer.getCart();
		Product product = productService.getProductById(productId);
		List<CartItem> cartItems = cart.getCartItems();

		// checks to see if same product is in the cart and adds to it if it
		// exists
		for (int i = 0; i < cartItems.size(); i++) {
			if (product.getProductId() == cartItems.get(i).getProduct().getProductId()) {
				CartItem cartItem = cartItems.get(i);
				cartItem.setQuantity(cartItem.getQuantity() + 1);
				cartItem.setTotalPrice(cartItem.getTotalPrice() * cartItem.getQuantity());
				cartItemService.addCartItem(cartItem);
			}

			CartItem cartItem = new CartItem();
			cartItem.setProduct(product);
			cartItem.setCart(cart);
			cartItem.setQuantity(1);
			cartItem.setTotalPrice(product.getProductPrice() * cartItem.getQuantity());
			cartItemService.addCartItem(cartItem);

		}
	}

	@RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeItem(@PathVariable int productId, HttpServletRequest request) {
		CartItem cartItem = cartItemService.getCartItemByProductId(productId);
		cartItemService.removeCartItem(cartItem);
	}

	@RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void clearCart(@PathVariable(value = "cartId") int cartId) {
		Cart cart = cartService.getCartById(cartId);
		cartItemService.removeAllCartItems(cart);
	}



 @ExceptionHandler(IllegalArgumentException.class)
 @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload")
 public void handleClientErrors(Exception e){}

 @ExceptionHandler(Exception.class)
 @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
 public void handleServerErrors(Exception e){}

}