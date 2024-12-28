package com.BaceletShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BraceletShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(BraceletShopApplication.class, args);
	}

}
