package com.ceh.spring.securitynodb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;

/**
 * Created by enHui.Chen on 2018/3/21 0021.
 */
@Configuration
// 若继承了WebSecurityConfigurerAdapter则不需要使用@EnableWebSecurity。若仍想使用spring boot的自动配置，
// 只对部分的内容进行修改，那么我们只需要@Configuration注解继承了WebSecurityConfigurerAdapter的类即可。
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

     /**
       * @Author: enHui.Chen
       * @Description: 继承WebSecurityConfigurerAdapter，重写该方法可实现对URL的拦截
       * @Data 2018/3/21 0021
       */
    @Override
    public void configure(HttpSecurity security) throws Exception {
        security.authorizeRequests()
                .antMatchers("/").permitAll() // 首先设置对所有路径不拦截
                .antMatchers("/admin/**").hasRole("ADMIN") // 拦截/admin路径并且角色为ADMIN才可访问
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/admin/hello") // 设置登录路径，登录成功后访问/admin/hello路径
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login"); // 配置注销路径，注销成功后跳转到/login路径
    }

     /**
       * @Author: enHui.Chen
       * @Description: 往内存中注册用户，并且配置用户角色
       * @Data 2018/3/21 0021
       */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser("user").password("user").roles("USER") // 不需要添加ROLE_前缀，Spring security为我们自动添加
                .and()
                .withUser("root").password("root").roles("ADMIN");
    }
}
