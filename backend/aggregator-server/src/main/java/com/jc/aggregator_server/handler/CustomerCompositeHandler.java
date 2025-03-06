package com.jc.aggregator_server.handler;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.jc.aggregator_server.dto.CustomerDto;
import com.jc.aggregator_server.dto.CustomerSummaryDto;
import com.jc.aggregator_server.dto.TicketDto;
import com.jc.aggregator_server.service.client.CustomerSummaryClient;
import com.jc.common.dto.ResponseDto;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CustomerCompositeHandler {

    private static final Logger logger = LoggerFactory.getLogger(CustomerCompositeHandler.class);

    private final CustomerSummaryClient customerSummaryClient;

    public Mono<ServerResponse> fetchCustomerSummary(ServerRequest request) {
        logger.info("Fetching customer summary");
        String uuid = request.queryParam("uuid").orElseThrow();

        Mono<ResponseEntity<ResponseDto<CustomerDto>>> customerSummary = customerSummaryClient.getCustomerSummary(uuid);
        Mono<ResponseEntity<ResponseDto<List<TicketDto>>>> ticketSummary = customerSummaryClient.getTicketSummary(uuid);

        return Mono.zip(customerSummary, ticketSummary)
                .flatMap(tuple -> {
                    ResponseDto<CustomerDto> customerResponse = tuple.getT1().getBody();
                    ResponseDto<List<TicketDto>> ticketResponse = tuple.getT2().getBody();

                    // Retrieve the data from the ResponseDto and return the concatenated data from
                    // the Customer and Ticket
                    CustomerDto customer = customerResponse.getData();
                    List<TicketDto> ticketList = ticketResponse.getData();
                    CustomerSummaryDto customerSummaryDto = new CustomerSummaryDto(customer, ticketList);

                    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                            .body(BodyInserters.fromValue(customerSummaryDto));
                });
    }
}
