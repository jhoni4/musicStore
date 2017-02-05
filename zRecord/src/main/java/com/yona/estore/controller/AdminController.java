package com.yona.estore.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.yona.estore.dao.ProductDao;
import com.yona.estore.model.Product;

@Controller
public class AdminController {

	private Path path;

	@Autowired
    private ProductDao productDao;

	/**
	 * Home view for admin page
	 *  **/
	@RequestMapping("/admin")
	public String adminPage() {
		return "admin";
	}
	
	/**
	 * View productInventory
	 * @param model (products)
	 * @return
	 **/

	@RequestMapping("/admin/productInventory")
	public String productInventory(Model model) {
		List<Product> products = productDao.getAllProducts();
		model.addAttribute("products", products);

		return "productInventory";
	}
	
	/**
	 * View addProduct
	 * @param model (products)
	 * @return
	 **/

	@RequestMapping("/admin/productInventory/addProduct")
	public String addProduct(Model model) {
		Product product = new Product();
		product.setProductCategory("instrument");
		product.setProductCondition("new");
		product.setProductStatus("active");

		// Here Model addAttribute(String attributeName, Object attributeValue)
		model.addAttribute("product", product);

		return "addProduct";
	}

	/**
	 * Add Product
	 * @param product
	 * @param result
	 * @return
	 **/
	// @ModelAttribute = binds a method return value to a named model
	// attribute(product),
	@RequestMapping(value = "/admin/productInventory/addProduct", method = RequestMethod.POST)
	public String addProductPost(@Valid @ModelAttribute(value = "product") Product product, BindingResult result,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			return "addProduct";
		}
		productDao.addProduct(product);
		// I thought the session is flushed already at this stage???

		MultipartFile productImage = product.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		// .get() = Converts a path string, or a sequence of strings that when
		// joined form a path string, to a Path.
		path = Paths.get(rootDirectory + "/WEB-INF/resources/images/" + product.getProductId() + ".png");

		if (productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(path.toString()));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Product image saving failed", e);
			}
		}

		return "redirect:/admin/productInventory";
	}

	/**
	 * Delete Product
	 * @param productId
	 * @return
	 **/
	@RequestMapping("/admin/productInventory/deleteProduct/{id}")
	public String deleteProduct(@PathVariable String id, Model model, HttpServletRequest request) {

		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "/WEB-INF/resources/images/" + id + ".png");

		if (Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		productDao.deleteProduct(id);

		return "redirect:/admin/productInventory";
	}

	@RequestMapping("/admin/productInventory/editProduct/{id}")
	public String editProduct(@PathVariable("id") String id, Model model) {
		Product product = productDao.getProductById(id);

		model.addAttribute(product);

		return "editProduct";
	}

	@RequestMapping(value = "/admin/productInventory/editProduct", method = RequestMethod.POST)
	public String editProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model,
			HttpServletRequest request) {

		if (result.hasErrors()) {
			return "editProduct";
		}

		// MultipartFile =Return the original filename in the client's
		// filesystem.
		MultipartFile productImage = product.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "/WEB-INF/resources/images/" + product.getProductId() + ".png");

		if (productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(path.toString()));
			} catch (Exception e) {
				throw new RuntimeException("Product image saving failed", e);
			}
		}

		productDao.editProduct(product);

		return "redirect:/admin/productInventory";
	}

}
