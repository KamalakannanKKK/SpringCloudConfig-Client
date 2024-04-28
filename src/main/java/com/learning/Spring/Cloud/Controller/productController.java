package com.learning.Spring.Cloud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.learning.Spring.Cloud.Model.Product;
import com.learning.Spring.Cloud.Service.ProductService;

@RestController
@RequestScope
public class productController {

	@Autowired
	@Qualifier(value="productService")
	private ProductService productService;
	
	@PostMapping("/addProduct")
	@ResponseStatus(code=HttpStatus.CREATED)
	public Product addProduct(@RequestBody Product product) {
		return this.productService.addProduct(product);
	}
	
	@PutMapping("/updateProduct/{id}")
	@ResponseStatus(code=HttpStatus.OK)
	public Product updateProduct(@RequestBody Product product,@PathVariable int id) {
		return this.productService.updateProduct(product,id);
	}
	
	@PutMapping("/deleteProduct/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void deleteProduct(@PathVariable int id) {
		 this.productService.deleteProductById(id);
	}
	
	@GetMapping("/Product/{id}")
	@ResponseStatus(code=HttpStatus.OK)
	public Product getProductById(@PathVariable("id") int id) {
		return this.productService.getProductById(id);
	}
	
	@GetMapping("/Product")
	@ResponseStatus(code=HttpStatus.OK)
	public List<Product> getAllProduct() {
		 return this.productService.getAllProduct();
	}
	
	@GetMapping("/Productname/{name}")
	@ResponseStatus(code=HttpStatus.OK)
	public List<Product> getProductByName(@PathVariable String name) {
		return this.productService.findByProductName(name);
	}
	
	@GetMapping("/Productbrand/{brand}")
	@ResponseStatus(code=HttpStatus.OK)
	public List<Product> getProductByBrand(@PathVariable String brand) {
		return this.productService.findByProductBrand(brand);
	}
	
	@GetMapping("/Productprice/{price}")
	@ResponseStatus(code=HttpStatus.OK)
	public List<Product> getProductByPrice(@PathVariable double price) {
		return this.productService.findByProductPrice(price);
	}
	
}
