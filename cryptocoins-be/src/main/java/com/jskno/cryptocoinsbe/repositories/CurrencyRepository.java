package com.jskno.cryptocoinsbe.repositories;

import com.jskno.cryptocoinsbe.domain.Currency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends CrudRepository<Currency, Long> {

    public Currency findCurrencyByTickerSymbol(String tickerSymbol);
}
