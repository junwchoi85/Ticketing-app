package com.jc.aggregator_server.service.client;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import com.jc.aggregator_server.dto.TicketDto;
import com.jc.aggregator_server.dto.CustomerDto;
import com.jc.common.dto.ResponseDto;

import reactor.core.publisher.Mono;

public interface UsersSummaryClient {

    /**
     * Get user by email
     * @param uuid
     * @return user
     */
    @GetExchange(value = "tikcet/users/api/get", accept = MediaType.APPLICATION_JSON_VALUE)
    Mono<ResponseEntity<ResponseDto<CustomerDto>>> getCustomer(@RequestParam("uuid") String uuid);

    /**
     * Get ticket by user id
     * @param uuid
     * @return
     */
    @GetExchange(value = "tikcet/tickets/api/get-ticket", accept = MediaType.APPLICATION_JSON_VALUE)
    Mono<ResponseEntity<ResponseDto<TicketDto>>> getTicket(@RequestParam("uuid") String uuid);
}
