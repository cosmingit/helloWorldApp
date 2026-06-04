package com.helloworld.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web configuration class for Spring Boot application.
 * Configures CORS settings to allow requests from frontend applications.
 */
@Slf4j
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Configure CORS settings to allow requests from frontend.
     * This configuration allows the React frontend to make requests to the backend API.
     *
     * @param registry the CORS registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        log.info("Configuring CORS settings");
        
        registry.addMapping("/api/**")
                .allowedOrigins(
                        "http://localhost:3000",      // React dev server
                        "http://localhost:5173",      // Vite dev server
                        "http://127.0.0.1:3000",
                        "http://127.0.0.1:5173"
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
        
        log.info("CORS configuration completed");
    }

}