package com.autuan.blog.config;

import com.autuan.blog.interceptor.BlogInterceptor;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new BlogInterceptor())
                .addPathPatterns("/log/**");
                //.excludePathPatterns("/back");
        super.addInterceptors(registry);
    }


    @Bean
    public Queue blogQueue(){
        return new Queue("blog");
    }

    @Bean
    public Queue linkQueue(){
        return new Queue("link");
    }
}
