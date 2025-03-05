package com.jc.aggregator_server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.jc.aggregator_server.handler.PingHandler;

@Configuration
class PingRouteConfiguration {

    @Bean
    public RouterFunction<ServerResponse> pingRoute(PingHandler pingHandler) {
        return RouterFunctions.route(RequestPredicates.GET("/ping"), pingHandler::ping);
    }
}