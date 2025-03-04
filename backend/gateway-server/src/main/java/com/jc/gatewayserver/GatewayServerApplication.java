package com.jc.gatewayserver;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServerApplication.class, args);
	}

	@Bean
	public RouteLocator routeConfig(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r
						.path("/ticket/users/**")
						.filters(f -> f.rewritePath("/ticket/users/(?<segment>.*)", "/${segment}") 	// Rewrite the path
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()) 		// Add a response header
								// .circuitBreaker(config -> config.setName("accountsCircuitBreaker")
								// 		.setFallbackUri("forward:/contactSupport"))
								)
						.uri("lb://USERS"))
				.route(r -> r
						.path("/ticket/tickets/**")
						.filters(f -> f.rewritePath("/ticket/tickets/(?<segment>.*)", "/${segment}") 	// Rewrite the path
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()) 		// Add a response header
								// .circuitBreaker(config -> config.setName("accountsCircuitBreaker")
								// 		.setFallbackUri("forward:/contactSupport"))
								)
						.uri("lb://TICKETS"))
				.route(r -> r
						.path("/ticket/aggregator/**")
						.filters(f -> f.rewritePath("/ticket/aggregator/(?<segment>.*)", "/${segment}") 	// Rewrite the path
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()) 		// Add a response header
								// .circuitBreaker(config -> config.setName("accountsCircuitBreaker")
								// 		.setFallbackUri("forward:/contactSupport"))
								)
						.uri("lb://AGGREGATOR"))
				.build();
	}
}
