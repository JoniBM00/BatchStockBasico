package com.viewnext.BatchStock.process;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductoProcessor {

	@Bean
	public ProductoItemProcessor processor() {
		return new ProductoItemProcessor();
	}
	
}
