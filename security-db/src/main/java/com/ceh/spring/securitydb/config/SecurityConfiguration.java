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

     /**
       * @Author: enHui.Chen
       * @Description: 1.将会按照声明的顺序进行过滤 2.对于hasRole方法，可以省略"ROLE_"前缀
       * @Data 2018/4/24
       */
    @Override
    public void configure(HttpSecurity security) throws Exception {
        security.authorizeRequests()
                .antMatchers("/","/home","/registryPage","/registry").permitAll()// 接口拦截配置
                .antMatchers("/jquery/**").permitAll()// 静态资源的拦截配置
                .antMatchers("/admin/**").hasRole("ADMIN")// 根据角色来放行
                .anyRequest().authenticated()// 拦截所有请求
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/admin/hello").permitAll()
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login");
//                        禁用跨域伪造请求,spring securiy默认开始CSRF功能，并且拦截POSTc请求方式的请求
//                .and()
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
