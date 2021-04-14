package com.example.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
    public CorsConfig(){}

    @Bean
    public CorsFilter corsFilter(){
        //1.添加cors配置信息
        CorsConfiguration corsConfiguration=new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("http://127.0.0.1:9000");
        corsConfiguration.addAllowedOrigin("http://localhost:9000");
        //设置是否发视cookie信息
        corsConfiguration.setAllowCredentials(true);
        //设置允许请求的发视
        corsConfiguration.addAllowedMethod("*");
        //设置允许的header
        corsConfiguration.addAllowedHeader("*");

        //2.为url添加映射路径
        UrlBasedCorsConfigurationSource corsSource=new UrlBasedCorsConfigurationSource();
        corsSource.registerCorsConfiguration("/**",corsConfiguration);

        //3.返回重新定义好的corsSource
        return new CorsFilter(corsSource);
    }
}
