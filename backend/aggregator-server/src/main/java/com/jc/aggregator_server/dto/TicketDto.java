package com.jc.aggregator_server.dto;

import java.time.LocalDateTime;

import com.jc.common.validation.ValidationGroups.ReadValidation;
import com.jc.common.validation.ValidationGroups.UpdateValidation;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class TicketDto {
    @NotEmpty(message = "UUID cannot be empty", groups = { ReadValidation.class, UpdateValidation.class })
    private String ticUuid;
    
    @NotEmpty(message = "UUID cannot be empty")
    private String eveUuid;
    @NotEmpty(message = "UUID cannot be empty")
    private String seaUuid;
    @NotEmpty(message = "UUID cannot be empty")
    private String cusUuid;
    private LocalDateTime purchaseDate;
    private String paymentStatus;
}
