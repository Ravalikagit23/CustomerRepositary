package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class  MongodbApplicationExp02 {

	public static void main(String[] args) {
		SpringApplication.run(MongodbApplicationExp02.class, args);
	}

}
