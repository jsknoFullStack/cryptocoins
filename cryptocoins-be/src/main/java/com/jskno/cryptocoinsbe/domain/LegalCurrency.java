package com.jskno.cryptocoinsbe.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(LegalCurrency.LEGAL_CURRENCY)
public class LegalCurrency extends Currency {

    protected final static String LEGAL_CURRENCY = "LEGAL_CURRENCY";
}
