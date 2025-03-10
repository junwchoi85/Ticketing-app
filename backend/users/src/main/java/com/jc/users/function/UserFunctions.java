package com.jc.users.function;

import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserFunctions {
    private static final Logger logger = LoggerFactory.getLogger(UserFunctions.class);

    @Bean
    public Consumer<String> messageConsumer() {
        return message -> {
            logger.info("\n\nMessage received: {}", message);
        };
    }
}
