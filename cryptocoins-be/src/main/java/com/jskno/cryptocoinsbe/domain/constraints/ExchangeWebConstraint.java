package com.jskno.cryptocoinsbe.domain.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ExchangeWebValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExchangeWebConstraint {

    String message() default "Invalid url";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
