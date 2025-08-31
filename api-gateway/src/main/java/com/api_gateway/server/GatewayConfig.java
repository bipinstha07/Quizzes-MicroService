package com.api_gateway.server;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import java.time.Duration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("category-service",route -> route.path("/category/**")
                        .filters(f->f.rewritePath("/category/?(?<remaining>.*)","/${remaining}")
                                .circuitBreaker(c->c.setName("categoryCB").setFallbackUri("forward:/categoryServiceFallback"))

                        )
                        .uri("lb://CATEGORY-SERVICE")
                )
                .route("quizzes",route->route.path("/quizzes/**")
                        .filters(f->f.rewritePath("/quizzes/?(?<remaining>.*)","/${remaining}")
                                .retry(retryConfig ->
                                        retryConfig.setMethods(HttpMethod.GET)
                                        .setRetries(3)
                                        .setBackoff(Duration.ofMillis(50),Duration.ofMillis(600),2,true)
                                ))
                        .uri("lb://QUIZESMONGO"))
                .build();
    }

}
