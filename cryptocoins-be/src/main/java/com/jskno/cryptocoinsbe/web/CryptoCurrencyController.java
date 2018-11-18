package com.jskno.cryptocoinsbe.web;

import com.jskno.cryptocoinsbe.domain.CryptoCurrency;
import com.jskno.cryptocoinsbe.domain.Currency;
import com.jskno.cryptocoinsbe.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/cryptocurrency")
public class CryptoCurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Currency createNewCurrency(@Valid @RequestBody CryptoCurrency currency) {
        return currencyService.saveOrUpdateCurrency(currency);
    }
}
