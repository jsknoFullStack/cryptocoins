package com.jskno.cryptocoinsbe.services;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolation;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class ValidationErrorsService {

    public Map<String, String> mapErrorsToMap(BindingResult result) {
        return result.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
    }

    public Map<String, String> mapErrorsToMap(Set<ConstraintViolation<?>> violations) {
        return violations.stream().collect(Collectors.toMap(
                x -> x.getMessage().split(Pattern.quote("->"))[0],
                x -> x.getMessage().split(Pattern.quote("->"))[1])
        );
    }

    public Map<String, String> mapErrorsToMap(MethodArgumentTypeMismatchException ex) {
        String error =
                ex.getName() + " should be of type " + ex.getRequiredType().getName();
        return Collections.singletonMap(ex.getName(),
                StringUtils.join("Expected type: ", ex.getRequiredType().getName(), ". Received value with wrong type: ", ex.getValue()));
    }
}
