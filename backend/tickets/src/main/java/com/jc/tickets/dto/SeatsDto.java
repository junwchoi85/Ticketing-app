package com.jc.tickets.dto;

import java.time.LocalDateTime;

import com.jc.common.validation.ValidationGroups.ReadValidation;
import com.jc.common.validation.ValidationGroups.UpdateValidation;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SeatsDto {
    @NotEmpty(message = "UUID cannot be empty", groups = { ReadValidation.class, UpdateValidation.class })
    private String seaUuid;
    @NotEmpty(message = "UUID cannot be empty")
    private String eveUuid;
    private String seatNumber;
    private String rowNumber;
    private String status;
    private Long reservedBy;
    private LocalDateTime reservedUntil;
}
