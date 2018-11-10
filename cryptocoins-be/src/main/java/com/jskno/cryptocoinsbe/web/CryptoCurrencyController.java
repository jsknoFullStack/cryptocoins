package com.jskno.cryptocoinsbe.web;

import com.jskno.cryptocoinsbe.domain.CryptoCurrency;
import com.jskno.cryptocoinsbe.domain.Currency;
import com.jskno.cryptocoinsbe.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cryptocurrency")
public class CryptoCurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @PostMapping("")
    public Currency createNewCurrency(@RequestBody CryptoCurrency currency) {
        return currencyService.saveOrUpdateCurrency(currency);
    }
}
