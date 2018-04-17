package com.ceh.spring.securityoatuth2.securityoatuth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

/**
 * Created by enHui.Chen on 2018/3/21 0021.
 */
@Configuration
public class ThymeleafConfiguration {
     /**
       * @Author: enHui.Chen
       * @Description: 再配置一个视图解析器
       * @Data 2018/3/23 0023
       */
    @Bean
    public ClassLoaderTemplateResolver classLoaderTemplateResolver() {
        ClassLoaderTemplateResolver classLoaderTemplateResolver = new ClassLoaderTemplateResolver();
        classLoaderTemplateResolver.setPrefix("web/");
        classLoaderTemplateResolver.setSuffix(".html");
        classLoaderTemplateResolver.setTemplateMode("HTML5");
        classLoaderTemplateResolver.setCharacterEncoding("UTF-8");
        classLoaderTemplateResolver.setOrder(1);
        return classLoaderTemplateResolver;
    }
}
