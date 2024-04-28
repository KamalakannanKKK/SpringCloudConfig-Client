package com.learning.Spring.Cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learning.Spring.Cloud.Model.Product;
import com.learning.Spring.Cloud.Repository.ProductRepository;

@SpringBootApplication
public class SpringCloudApplication implements CommandLineRunner{

	@Autowired
	@Qualifier(value="productRepository")
	private ProductRepository productRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productRepository.save(new Product(null,"LG","TV",14000.0));
		productRepository.save(new Product(null,"DELL","Monitor",90000.0));
		productRepository.save(new Product(null,"SONY","Refridgerator",14000.0));
	}

}
