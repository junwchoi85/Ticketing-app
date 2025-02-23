package com.jc.gateway_server;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServerApplication.class, args);
	}

	public RouteLocator routeConfig(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r
						.path("/ticket/users/**")
						.filters(f -> f.rewritePath("/ticket/users/(?<segment>.*)", "/${segment}")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
								// .circuitBreaker(config -> config.setName("accountsCircuitBreaker")
								// 		.setFallbackUri("forward:/contactSupport"))
								)
						.uri("lb://USERS"))
				.build();
	}
}
