package com.wayn.admin.framework.config;

import com.wayn.common.config.WaynConfig;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 本地文件上传路径
        registry.addResourceHandler("/upload/**").addResourceLocations("file:" + WaynConfig.getUploadDir() + "/");
    }

    @Bean
    public FilterRegistrationBean<RequestWrapperFilter> firstFilter() {
        FilterRegistrationBean<RequestWrapperFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new RequestWrapperFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(20);
        return registrationBean;
    }
}
