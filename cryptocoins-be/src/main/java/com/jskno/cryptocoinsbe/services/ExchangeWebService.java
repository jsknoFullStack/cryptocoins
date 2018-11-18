package com.jskno.cryptocoinsbe.services;

import com.jskno.cryptocoinsbe.domain.ExchangeWeb;
import com.jskno.cryptocoinsbe.exceptions.EntityNotFoundException;
import com.jskno.cryptocoinsbe.repositories.ExchangeWebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExchangeWebService {

    @Autowired
    private ExchangeWebRepository exchangeWebRepository;

    public ExchangeWeb saveOrUpdateExchangeWeb(ExchangeWeb exchangeWeb) {
        return exchangeWebRepository.save(exchangeWeb);
    }

    public ExchangeWeb getExchangeWebById(Long exchangeWebId) {
        Optional<ExchangeWeb> exchangeWebOpt = exchangeWebRepository.findById(exchangeWebId);
        return exchangeWebOpt.orElseThrow(
                () -> new EntityNotFoundException("exchangeWebId", new StringBuilder()
                        .append("Cannot find Todo Item with ID '")
                        .append(exchangeWebId)
                        .append("'. This item does not exist").toString())
        );
    }

    public void deleteExchangeWebById(Long exchangeWebId) {
        Optional<ExchangeWeb> exchangeWebOpt = exchangeWebRepository.findById(exchangeWebId);
        if(exchangeWebOpt.isPresent()) {
            throw new EntityNotFoundException("exchangeWebId", new StringBuilder()
                    .append("Cannot find Todo Item with ID '")
                    .append(exchangeWebId)
                    .append("'. This item does not exist").toString());
        }
        exchangeWebRepository.delete(exchangeWebOpt.get());
    }

    public Iterable<ExchangeWeb> findAllExchangeWebs() {
        return exchangeWebRepository.findAll();
    }


}
