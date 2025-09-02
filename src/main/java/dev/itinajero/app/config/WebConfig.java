package dev.itinajero.app.config;

import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${csv.output.dir}")
    private String csvOutputDir;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/csv/**").addResourceLocations("file:" + csvOutputDir).
		setCacheControl(CacheControl.maxAge(365, TimeUnit.DAYS)); // Set browser to use the cached version of the file for one year.; 
    }

}
