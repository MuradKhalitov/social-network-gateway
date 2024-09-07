package ru.skillbox.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("social-network-account",
                        r -> r.path("/api/v1/account/**")
                                .uri("lb://SOCIAL-NETWORK-ACCOUNT"))
                .route("social-network-auth",
                        r -> r.path("/api/v1/auth/**")
                                .uri("lb://SOCIAL-NETWORK-AUTH"))
                .route("social-network-dialog",
                        r -> r.path("/api/v1/dialogs/**")
                                .uri("lb://SOCIAL-NETWORK-DIALOG"))
                .route("social-network-post",
                        r -> r.path("/api/v1/post/**")
                                .uri("lb://SOCIAL-NETWORK-POST"))
                .build();
    }

}
