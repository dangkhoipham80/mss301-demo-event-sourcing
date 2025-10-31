package com.khoipdse.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class GatewayserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayserverApplication.class, args);
    }

    @Bean
    public RouteLocator eazyBankRouteConfig(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(p -> p
                        .path("/customer/api/v1", "/customer/api/v1/**")
                        .filters(f -> f.rewritePath("/customer/api/v1(?<segment>/.*)?", "/api/v1${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://CUSTOMER"))
                .route(p -> p
                        .path("/accounts/api/v1", "/accounts/api/v1/**")
                        .filters(f -> f.rewritePath("/accounts/api/v1(?<segment>/.*)?", "/api/v1${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://ACCOUNTS"))
                .route(p -> p
                        .path("/loans/api/v1", "/loans/api/v1/**")
                        .filters(f -> f.rewritePath("/loans/api/v1(?<segment>/.*)?", "/api/v1${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://LOANS"))
                .route(p -> p
                        .path("/cards/api/v1", "/cards/api/v1/**")
                        .filters(f -> f.rewritePath("/cards/api/v1(?<segment>/.*)?", "/api/v1${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://CARDS")).build();


    }


}
