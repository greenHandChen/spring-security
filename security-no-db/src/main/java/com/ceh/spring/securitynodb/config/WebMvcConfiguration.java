package com.ceh.spring.securitynodb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by enHui.Chen on 2018/3/21 0021.
 */
@Configuration
// 若我们仍想使用spring boot为我们提供的自动配置，但是只想做部分的修改，
// 那么我们只需要使用@EnableWebMvc注解来注解继承了WebMvcConfigurerAdapter的类即可。
public class WebMvcConfiguration extends WebMvcConfigurerAdapter{
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/login").setViewName("login");
    }

}
