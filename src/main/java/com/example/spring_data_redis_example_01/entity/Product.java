package com.example.spring_data_redis_example_01.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Product")
public class Product {
	
	@Id
	private int id;
	private String name;
	private int qty;
	private long price;
		
}




