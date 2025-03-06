package com.jc.aggregator_server.service.client;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import com.jc.aggregator_server.dto.CustomerDto;
import com.jc.aggregator_server.dto.TicketDto;
import com.jc.common.dto.ResponseDto;

import reactor.core.publisher.Mono;

public interface CustomerSummaryClient {
    
    @GetExchange(value="/ticket/users/api/getByUuid", accept = "application/json")
    Mono<ResponseEntity<ResponseDto<CustomerDto>>> getCustomerSummary(@RequestParam("uuid") String uuid);

    @GetExchange(value="/ticket/tickets/api/get-ticket", accept = "application/json")
    Mono<ResponseEntity<ResponseDto<List<TicketDto>>>> getTicketSummary(@RequestParam("uuid") String uuid);
}
