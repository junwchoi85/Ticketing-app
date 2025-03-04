package com.jc.users.dto;

import com.jc.common.validation.ValidationGroups.ReadValidation;
import com.jc.common.validation.ValidationGroups.UpdateValidation;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CustomerDto {

    @NotEmpty(message = "UUID cannot be empty", groups = { ReadValidation.class, UpdateValidation.class })
    private String uuid;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    private String email;

    @NotEmpty(message = "Password cannot be empty")
    private String password;
}
