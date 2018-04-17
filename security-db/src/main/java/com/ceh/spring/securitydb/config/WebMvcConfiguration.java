package com.ceh.spring.securitydb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by enHui.Chen on 2018/3/21 0021.
 */
// 若只想对spring boot的自动配置做部分修改，那么使用@Configuration注解去注解继承了WebMvcConfigureAdapter的类即可。
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter{

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/registryPage").setViewName("registry");
    }
}
