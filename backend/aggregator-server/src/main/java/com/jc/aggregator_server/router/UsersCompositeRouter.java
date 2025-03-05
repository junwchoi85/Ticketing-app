package com.jc.aggregator_server.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.jc.aggregator_server.handler.UsersCompositeHandler;

@Configuration(proxyBeanMethods = false)
public class UsersCompositeRouter {

    @Bean
    public RouterFunction<ServerResponse> route(UsersCompositeHandler handler) {
        return RouterFunctions.route(RequestPredicates.GET("/api/composite/getUserSummary")
                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON))
                .and(RequestPredicates.queryParam("userEmail", param -> true)),
                handler::getUsersSummary);
    }

}
