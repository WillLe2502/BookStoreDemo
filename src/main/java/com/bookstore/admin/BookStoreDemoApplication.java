package com.bookstore.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.bookstore.admin.entity", "com.bookstore.admin.user"})
public class BookStoreDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreDemoApplication.class, args);
	}

}
