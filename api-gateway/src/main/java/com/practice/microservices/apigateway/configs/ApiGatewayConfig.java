package com.practice.microservices.apigateway.configs;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ApiGatewayConfig {

    @Bean
    public RouteLocator gatewayRouter(final RouteLocatorBuilder routeLocatorBuilder) {

        return routeLocatorBuilder
                .routes()
                .route(routeCurrencyExchange())
                .route(routeCurrencyConversion())
                .build();
    }

    private Function<PredicateSpec, Buildable<Route>> routeCurrencyExchange() {

        return route ->
                route.path("/currency-exchange/**")
                .uri("lb://currency-exchange");
    }

    private Function<PredicateSpec, Buildable<Route>> routeCurrencyConversion() {

        return route ->
                route.path("/currency-conversion/**")
                .uri("lb://currency-conversion");
    }

}
