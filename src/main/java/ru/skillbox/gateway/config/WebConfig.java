//package ru.skillbox.gateway.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.reactive.config.CorsRegistry;
//import org.springframework.web.reactive.config.WebFluxConfigurer;
//
//@Configuration
//public class WebConfig implements WebFluxConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("http://89.111.174.153:8080")
//                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH")
//                .allowedHeaders("*")
//                .allowCredentials(true);
//    }
//}