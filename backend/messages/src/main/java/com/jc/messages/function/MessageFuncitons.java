package com.jc.messages.function;

import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jc.messages.dto.CustomerMsgDto;

@Configuration
public class MessageFuncitons {
    private static final Logger logger = LoggerFactory.getLogger(MessageFuncitons.class);

    @Bean
    public Function<CustomerMsgDto, CustomerMsgDto> messageSupplier() {
        return customerMsgDto -> {
            logger.info("Message generated for customer: {}", customerMsgDto.email());
            return customerMsgDto;
        };
    }
}
