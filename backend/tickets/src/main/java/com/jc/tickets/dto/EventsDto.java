package com.jc.tickets.dto;

import com.jc.common.validation.ValidationGroups.ReadValidation;
import com.jc.common.validation.ValidationGroups.UpdateValidation;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class EventsDto {

    @NotEmpty(message = "UUID cannot be empty", groups = { ReadValidation.class, UpdateValidation.class })
    private String eveUuid;

    private String title;
    private String description;
    private String venue;    
}
