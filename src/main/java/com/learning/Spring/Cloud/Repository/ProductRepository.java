package com.learning.Spring.Cloud.Repository;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.Spring.Cloud.Model.Product;

@Repository(value="productRepository")
@Scope(value="singleton")
public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByName(String product);
	List<Product> findByBrand(String brand);
	List<Product> findByPrice(double price);
	
}
