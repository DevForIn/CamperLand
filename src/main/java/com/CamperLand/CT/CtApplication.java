package com.CamperLand.CT;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.CamperLand.CT")
public class CtApplication {

	public static void main(String[] args) {
		SpringApplication.run(CtApplication.class, args);
	}

}
