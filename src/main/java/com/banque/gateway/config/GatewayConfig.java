package com.banque.gateway.config;

import com.banque.gateway.filter.AuthenticationFilter;
import com.banque.gateway.filter.AuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Autowired
    private AuthenticationFilter authenticationFilter;


    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // CLIENT Routes
                .route("Transactions", r -> r.path("/api/Virement/**")
                        .filters(f -> f.filter(authenticationFilter)
                                .filter(authorizationFilter("CLIENT"))) // Ensure this is executed in order
                        .uri("lb://Transactions")) // URL for the transaction microservice
                .route("Transactions", r -> r.path("/api/Factures/**")
                        .filters(f -> f.filter(authenticationFilter)
                                .filter(authorizationFilter("CLIENT"))) // Ensure this is executed in order
                        .uri("lb://Transactions")) // URL for the transactions microservice
                .build();
    }

    private AuthorizationFilter authorizationFilter(String requiredRole) {
        return new AuthorizationFilter(requiredRole);
    }
}
