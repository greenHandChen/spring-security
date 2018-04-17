package com.ceh.spring.securitynodb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

/**
 * Created by enHui.Chen on 2018/3/21 0021.
 */
@Configuration
public class ThymeleafConfiguration {

    @Bean
    public ClassLoaderTemplateResolver classLoaderTemplateResolver(){
        ClassLoaderTemplateResolver loaderTemplateResolver = new ClassLoaderTemplateResolver();
        loaderTemplateResolver.setPrefix("");
        loaderTemplateResolver.setSuffix(".html");
        loaderTemplateResolver.setTemplateMode("HTML5");
        loaderTemplateResolver.setCharacterEncoding("UTF-8");
        loaderTemplateResolver.setOrder(1);
        return loaderTemplateResolver;
    }
}
