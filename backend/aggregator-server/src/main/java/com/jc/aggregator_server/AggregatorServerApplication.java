package com.jc.aggregator_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })@EnableDiscoveryClient
public class AggregatorServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AggregatorServerApplication.class, args);
	}

}
