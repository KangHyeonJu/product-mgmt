package com.backend.product_mgmt;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
public class ProductMgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductMgmtApplication.class, args);
	}

//	@Bean
//	public ModelMapper modelMapper(){
//		ModelMapper modelMapper = new ModelMapper();
//
//		modelMapper.getConfiguration()
//				.setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
//				.setFieldMatchingEnabled(true);
//
//		return modelMapper;
//	}

	@Bean
	@Profile("prod")
	public ApplicationRunner runner(DataSource dataSource){
		return args -> {
			Connection connection = dataSource.getConnection();
		};
	}
}
