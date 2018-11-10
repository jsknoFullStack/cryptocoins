package com.jskno.cryptocoinsbe.services;

import com.jskno.cryptocoinsbe.domain.ExchangeWeb;
import com.jskno.cryptocoinsbe.repositories.ExchangeWebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeWebService {

    @Autowired
    private ExchangeWebRepository exchangeWebRepository;

    public ExchangeWeb saveOrUpdateExchangeWeb(ExchangeWeb exchangeWeb) {
        return exchangeWebRepository.save(exchangeWeb);
    }
}
