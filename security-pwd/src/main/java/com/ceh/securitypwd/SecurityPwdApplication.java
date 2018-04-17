package com.ceh.securitypwd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ceh.securitypwd.mapper")
public class SecurityPwdApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityPwdApplication.class, args);
	}
}
