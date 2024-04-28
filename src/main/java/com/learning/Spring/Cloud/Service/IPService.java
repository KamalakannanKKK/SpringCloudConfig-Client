package com.learning.Spring.Cloud.Service;

import java.util.List;

import com.learning.Spring.Cloud.Model.Product;

public interface IPService {

	public Product addProduct(Product product);
	public Product updateProduct(Product product,int id);
	public List<Product> getAllProduct();
	public Product getProductById(int id);
	public void deleteProductById(int id);
	
	public List<Product> findByProductName(String name);
	public List<Product> findByProductBrand(String brand);
	public List<Product> findByProductPrice(double price);
}
