package com.jc.tickets.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TicketsDto {
    private Long eventId;
    private Long seatId;
    private Long userId;
    private LocalDateTime purchaseDate;
    private String paymentStatus;
}
