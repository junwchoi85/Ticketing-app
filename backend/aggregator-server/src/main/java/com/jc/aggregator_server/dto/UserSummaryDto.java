package com.jc.aggregator_server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserSummaryDto {
    private CustomerDto customerDto;
    private TicketDto ticketDto;
}
