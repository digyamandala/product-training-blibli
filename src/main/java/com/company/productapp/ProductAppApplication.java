package com.company.productapp;

import com.company.productapp.entity.ApiKeyHandlerMethodArgumentResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@SpringBootApplication
public class ProductAppApplication implements WebMvcConfigurer {

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		resolvers.add(new ApiKeyHandlerMethodArgumentResolver());
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductAppApplication.class, args);
	}

}
