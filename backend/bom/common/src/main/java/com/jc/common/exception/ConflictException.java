package com.jc.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ConflictException extends RuntimeException {
    public ConflictException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s already exists with the given input data %s : '%s'", resourceName, fieldName, fieldValue));
    }
    
}
