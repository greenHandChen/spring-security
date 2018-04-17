package com.ceh.spring.securityoatuth2.securityoatuth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by enHui.Chen on 2018/4/10.
 */
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/hello").hasAnyAuthority("ROLE_USER")
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/hello")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login");
    }

     /**
       * @Author: enHui.Chen
       * @Description: 使用数据库中的用户进行认证
       * @Data 2018/4/10
       */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
