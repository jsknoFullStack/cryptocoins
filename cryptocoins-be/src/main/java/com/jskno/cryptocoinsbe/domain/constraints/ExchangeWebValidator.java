package com.jskno.cryptocoinsbe.domain.constraints;

import com.jskno.cryptocoinsbe.domain.ExchangeWeb;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExchangeWebValidator implements ConstraintValidator<ExchangeWebConstraint, ExchangeWeb> {

    @Override
    public void initialize(ExchangeWebConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(ExchangeWeb exchangeWeb, ConstraintValidatorContext constraintValidatorContext) {
        return exchangeWeb.getUrl().startsWith("www");
    }
}
