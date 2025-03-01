package com.jc.tickets.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SeatsDto {
    private String seatNumber;
    private String rowNumber;
    private String status;
    private Long reservedBy;
    private LocalDateTime reservedUntil;
}
