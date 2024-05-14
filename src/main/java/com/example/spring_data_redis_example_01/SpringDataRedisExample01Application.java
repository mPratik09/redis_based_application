package com.example.spring_data_redis_example_01;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_data_redis_example_01.entity.Product;
import com.example.spring_data_redis_example_01.repo.ProductDao;

@SpringBootApplication
@RestController
@RequestMapping("/product")
public class SpringDataRedisExample01Application {
	
	@Autowired
	private ProductDao dao;
	
	@PostMapping
	public Product save(@RequestBody Product product) {
		return dao.save(product);
	}
	
	@GetMapping
	public List<Product> getAllProducts() {
		return dao.findAll();
	}
	
	@GetMapping("/{id}")
	public Product findProduct(@PathVariable int id) {
		return dao.findProductById(id);
	}
	
	@DeleteMapping("/{id}")
	public String remove(@PathVariable int id) {
		return dao.deleteProduct(id);
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataRedisExample01Application.class, args);
	}

}
