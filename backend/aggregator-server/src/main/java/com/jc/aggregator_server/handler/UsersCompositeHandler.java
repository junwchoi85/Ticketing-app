package com.jc.aggregator_server.handler;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.jc.aggregator_server.dto.TicketDto;
import com.jc.aggregator_server.dto.UserSummaryDto;
import com.jc.aggregator_server.dto.CustomerDto;
import com.jc.aggregator_server.service.client.UsersSummaryClient;
import com.jc.common.dto.ResponseDto;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UsersCompositeHandler {
    private final UsersSummaryClient usersClient;

    public Mono<ServerResponse> getUsersSummary(ServerRequest serverRequest) {
        String cus_uuid = serverRequest.queryParam("customerId").get();    // This is the customer's uuid

        Mono<ResponseEntity<ResponseDto<CustomerDto>>> userMono = usersClient.getCustomer(cus_uuid);
        Mono<ResponseEntity<ResponseDto<TicketDto>>> ticketMono = usersClient.getTicket(cus_uuid);
        return Mono.zip(userMono, ticketMono)
                .flatMap(tuple -> {
                    ResponseEntity<ResponseDto<CustomerDto>> userResponse = tuple.getT1();
                    ResponseEntity<ResponseDto<TicketDto>> ticketResponse = tuple.getT2();

                    CustomerDto usersDto = userResponse.getBody().getData();
                    TicketDto ticketsDto = ticketResponse.getBody().getData();

                    UserSummaryDto userSummaryDto = new UserSummaryDto(usersDto, ticketsDto);
                    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                            .body(BodyInserters.fromValue(userSummaryDto));
                });
    }
}
