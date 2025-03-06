package com.jc.aggregator_server.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerSummaryDto {
    private CustomerDto customer;
    private List<TicketDto> ticket;
}
