package com.jskno.cryptocoinsbe.web;

import com.jskno.cryptocoinsbe.domain.Currency;
import com.jskno.cryptocoinsbe.domain.LegalCurrency;
import com.jskno.cryptocoinsbe.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/legalcurrency")
public class LegalCurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @PostMapping("")
    public Currency createNewCurrency(@RequestBody LegalCurrency currency) {
        return currencyService.saveOrUpdateCurrency(currency);
    }
}
