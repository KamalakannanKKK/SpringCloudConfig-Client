package com.learning.Spring.Cloud.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.learning.Spring.Cloud.Model.Product;
import com.learning.Spring.Cloud.Repository.ProductRepository;

@Service(value="productService")
@Scope(value="singleton")
public class ProductService implements IPService{

	@Autowired
	@Qualifier(value="productRepository")
	private ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		return this.productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product, int id) {
		Product old=this.productRepository.findById(id).get();
		old.setName(product.getName());
		old.setBrand(product.getBrand());
		old.setPrice(product.getPrice());
		
		return this.productRepository.save(old);
	}

	@Override
	public List<Product> getAllProduct() {
		return this.productRepository.findAll();
	}

	@Override
	public Product getProductById(int id) {
		return this.productRepository.findById(id).get();
	}

	@Override
	public void deleteProductById(int id) {
		this.productRepository.deleteById(id);
		
	}

	@Override
	public List<Product> findByProductName(String name) {
		return this.productRepository.findByName(name);
	}

	@Override
	public List<Product> findByProductBrand(String brand) {
		return this.productRepository.findByBrand(brand);
	}

	@Override
	public List<Product> findByProductPrice(double price) {
		return this.productRepository.findByPrice(price);
	}
}
