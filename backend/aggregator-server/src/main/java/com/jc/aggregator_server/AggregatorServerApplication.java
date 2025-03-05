package com.jc.aggregator_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;



@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class AggregatorServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AggregatorServerApplication.class, args);
	}

}
