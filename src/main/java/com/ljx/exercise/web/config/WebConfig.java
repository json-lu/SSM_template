package com.ljx.exercise.web.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

/**
 * <p>
 *
 * </p>
 *
 * @Since: Created  in 15:01 2020/12/21
 * @Author: Ljx
 * @Decription:
 */
public class WebConfig implements WebMvcConfigurer {

    //配置资源访问路径映射
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        File file = new File("src/main/webapp/upload");
        String fileDisk = file.getAbsolutePath();
        System.out.println(fileDisk);

        registry.addResourceHandler("/upload/*").addResourceLocations(fileDisk+File.separator);
    }
}
