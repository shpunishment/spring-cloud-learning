package com.shpun.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Description:
 * @Author: sun
 * @Date: 2020/9/18 10:57
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 默认每个请求都需要添加CSRF token才能访问
        // Eureka客户端注册时并不会添加，所以需要配置/eureka/**路径不需要CSRF token。
        http.csrf().ignoringAntMatchers("/eureka/**");
        super.configure(http);
    }

}
