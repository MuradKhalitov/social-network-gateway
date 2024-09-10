package ru.skillbox.gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import reactor.core.publisher.Mono;

@Configuration
@Slf4j
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

    @Bean
    public GlobalFilter loggingFilter() {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            log.info("Request: {} {} {}", request.getMethod(), request.getPath(), request.getURI());
            return chain.filter(exchange).then(Mono.fromRunnable(() ->
                    log.info("Response: {} {} {}", exchange.getResponse().getStatusCode(), request.getPath(), request.getURI())));
        };
    }
    // INFO ru.skillbox.gateway.config.GatewayConfig - Request: GET /api/v1/account/users http://localhost:8080/api/v1/account/users
    // INFO ru.skillbox.gateway.config.GatewayConfig - Response: 200 OK /api/v1/account/users http://localhost:8080/api/v1/account/users

//    @Bean
//    public GlobalFilter loggingFilter() {
//        return (exchange, chain) -> {
//            ServerHttpRequest request = exchange.getRequest();
//            log.info("Request: {} {} {}", request.getMethod(), request.getPath(), request.getURI());
//            return chain.filter(exchange);
//        };
//    }
//    // INFO  ru.skillbox.gateway.config.GatewayConfig  - Request: GET /api/v1/account/users  http://localhost:8080/api/v1/account/users

}
