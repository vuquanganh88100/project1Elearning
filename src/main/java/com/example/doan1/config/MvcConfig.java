package com.example.doan1.config;

import com.example.doan1.utils.FileUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/images/**")// vói đường đãn url bắt đầu bằng images/
                .addResourceLocations("file:/" + FileUtils.FOLDER_MEDIA );// thì nó sẽ vào thư mục FOLDER_MEDIA lấy file
    }}
