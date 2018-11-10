package com.jskno.cryptocoinsbe.services;

import com.jskno.cryptocoinsbe.domain.Currency;
import com.jskno.cryptocoinsbe.repositories.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    public Currency saveOrUpdateCurrency(Currency currency) {
        return currencyRepository.save(currency);
    }
}
