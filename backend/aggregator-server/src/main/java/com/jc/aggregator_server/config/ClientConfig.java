package com.jc.aggregator_server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;


import com.jc.aggregator_server.service.client.UsersSummaryClient;

@Configuration
public class ClientConfig {
    @Value("${app.base-url}")
    private String baseUrl;

    @Bean
    UsersSummaryClient usersClient() {
        // WebClient: A non-blocking, reactive client for making HTTP requests.
        WebClient webClient = WebClient.builder().baseUrl(baseUrl).build();
        // WebClientAdapter: Adapts the WebClient to be used with the HttpServiceProxyFactory.
        WebClientAdapter adapter = WebClientAdapter.create(webClient);
        // HttpServiceProxyFactory: Creates a proxy for the UsersSummaryClient interface, 
        // allowing it to be used as a client for making HTTP requests.
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
        return factory.createClient(UsersSummaryClient.class);
    }

}
