package com.ceh.spring.securitydb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by enHui.Chen on 2018/3/21 0021.
 */
// 若只想对自动配置做部分修改，那么不需要使用@EnableWebSecurity注解去注解继承了WebSecurityConfigurerAdapter的类
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public void configure(HttpSecurity security) throws Exception {
        security.authorizeRequests()
                .antMatchers("/").permitAll() // 包含了对静态资源的不拦截 ?
                .antMatchers("/admin/**").hasRole("ADMIN")
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/admin/hello")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login")
                .and();
//                禁用跨域伪造请求,spring securiy默认开始CSRF功能，并且拦截POSTc请求方式的请求
//                .csrf().disable();
    }

    /**
     * @Author: enHui.Chen
     * @Description: 1.自定义认证，通过数据库中的用户进行认证
     * 2.内存中注册用户
     * @Data 2018/3/22 0022
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        //1
        builder.userDetailsService(userDetailsService);
        /*2. builder.inMemoryAuthentication()
                .withUser("root").password("root").roles("ADMIN");*/
    }


}
