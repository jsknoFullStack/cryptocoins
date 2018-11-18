package com.jskno.cryptocoinsbe.services;

import com.jskno.cryptocoinsbe.domain.Currency;
import com.jskno.cryptocoinsbe.exceptions.EntityConstraintViolationException;
import com.jskno.cryptocoinsbe.repositories.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    public Currency saveOrUpdateCurrency(Currency currency) {
        try {
            currency.setTickerSymbol(currency.getTickerSymbol().toUpperCase());
            return currencyRepository.save(currency);
        } catch(DataIntegrityViolationException ex) {
            throw new EntityConstraintViolationException("uniqueTickerSymbol",
                    new StringBuilder()
                            .append("This currency already exist")
                            .append(currency.getName())
                            .toString());
        }
    }

    public Currency findCurrencyByTickerSymbol(String tickerSymbol) {
        return currencyRepository.findCurrencyByTickerSymbol(tickerSymbol);
    }

    public Iterable<Currency> findAllCurrencies() {
        return currencyRepository.findAll();
    }

    public void deleteCurrencyByTickerSymbol(String tickerSymbol) {
        Currency currency = currencyRepository.findCurrencyByTickerSymbol(tickerSymbol);
        if(currency == null) {

        }
        currencyRepository.delete(currency);
    }
}
