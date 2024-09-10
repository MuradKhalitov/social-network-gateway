//package ru.skillbox.gateway.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.reactive.CorsConfigurationSource;
//import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
//import org.springframework.web.reactive.config.WebFluxConfigurer;
//
//@Configuration
//public class CorsConfig implements WebFluxConfigurer {
//
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration config = new CorsConfiguration();
//        config.addAllowedOrigin("http://localhost:8080"); // Указываем разрешенный источник
//        config.addAllowedMethod("*"); // Разрешаем все методы
//        config.addAllowedHeader("*"); // Разрешаем все заголовки
//        config.setAllowCredentials(true); // Разрешаем отправку учетных данных
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", config); // Применяем ко всем маршрутам
//
//        return source;
//    }
//}

