package com.ceh.spring.securityoatuth2.securityoatuth2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ceh.spring.securityoatuth2.securityoatuth2")
public class SecurityOatuth2Application {

	public static void main(String[] args) {
		SpringApplication.run(SecurityOatuth2Application.class, args);
	}
}
