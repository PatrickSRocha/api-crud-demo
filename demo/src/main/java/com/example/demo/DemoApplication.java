package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** 
 * Main class responsble for starting the Spring Boot application. 
 * 
 * @version 1.0
 * @since 11-02-2026
*/
@SpringBootApplication
public class DemoApplication{
	public static void main(String[] args){
		SpringApplication.run(DemoApplication.class, args);
	}
}