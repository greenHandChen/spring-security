package com.ceh.spring.securityoatuth2.securityoatuth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.*;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * Created by enHui.Chen on 2018/4/9.
 */
@Configuration
public class Oauth2ServerConfiguration {
    private static final String DEMO_RESOURCE_ID = "AUTHENTICATION";

    @Configuration
    @EnableResourceServer
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

        @Override
        public void configure(ResourceServerSecurityConfigurer resourceServerConfigurer) {
            resourceServerConfigurer.resourceId(DEMO_RESOURCE_ID).stateless(true);
        }

        @Override
        public void configure(HttpSecurity security) throws Exception {
            security.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                    .and()
                    .requestMatchers().anyRequest()
                    .and()
                    .anonymous()
                    .and()
                    .authorizeRequests()
                    .antMatchers("/myOauth/authentication/**").authenticated(); // 设置保护的资源
        }
    }

    @Configuration
    @EnableAuthorizationServer
    public static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
        @Autowired
        @Qualifier("authenticationManagerBean")
        private AuthenticationManager authenticationManager;
        @Autowired
        private RedisConnectionFactory redisConnectionFactory;

        @Override
        public void configure(ClientDetailsServiceConfigurer clientDetailsServiceConfigurer) throws Exception {
            // 配置客户端
            clientDetailsServiceConfigurer.inMemory()
                    .withClient("client_1")
                    .resourceIds(DEMO_RESOURCE_ID)
                    .authorizedGrantTypes("client_credentials", "refresh_token")
                    .scopes("write", "read")
                    .authorities("client_1")
                    .secret("123456")
                    .and()
                    .withClient("client_2")
                    .resourceIds(DEMO_RESOURCE_ID)
                    .authorizedGrantTypes("password", "refresh_token")
                    .scopes("read")
                    .authorities("client_2")
                    .secret("123456");
        }

         /**
           * @Author: enHui.Chen
           * @Description: 配置存储方式
           * @Data 2018/4/17
           */
        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpointsConfigurer) {
            endpointsConfigurer.tokenStore(new RedisTokenStore(redisConnectionFactory))
                    .authenticationManager(authenticationManager);
        }

         /**
           * @Author: enHui.Chen
           * @Description: 允许表单验证
           * @Data 2018/4/17
           */
        @Override
        public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
            oauthServer.allowFormAuthenticationForClients();
        }
    }
}
