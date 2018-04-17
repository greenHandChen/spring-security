package com.ceh.spring.securitydb;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ceh.spring.securitydb.mapper")
public class SecurityDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityDbApplication.class, args);
	}
}
