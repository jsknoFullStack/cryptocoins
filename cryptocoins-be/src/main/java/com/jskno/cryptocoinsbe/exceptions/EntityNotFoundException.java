package com.jskno.cryptocoinsbe.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EntityNotFoundException extends RuntimeException {

    private String entityField;

    public EntityNotFoundException(String message, String entityField) {
        super(message);
        this.entityField = entityField;
    }

    public String getEntityField() {
        return entityField;
    }
}
