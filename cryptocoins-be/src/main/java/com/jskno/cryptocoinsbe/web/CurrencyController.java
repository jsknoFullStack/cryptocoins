package com.jskno.cryptocoinsbe.web;

import com.jskno.cryptocoinsbe.domain.Currency;
import com.jskno.cryptocoinsbe.domain.LegalCurrency;
import com.jskno.cryptocoinsbe.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/api/legalcurrency")
@Validated
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/{tickerSymbol}")
    @ResponseStatus(HttpStatus.OK)
    public Currency getCurrencyByTickerSymbol(
            @NotBlank(message = "tickerSymbol->The ticker symbol is required")
            @Size(min = 3, max = 8, message = "tickerSymbol->The ticker symbol must be between 3 and 8 characters")
            @PathVariable String tickerSymbol) {

        return currencyService.findCurrencyByTickerSymbol(tickerSymbol);
    }

    @DeleteMapping("/{tickerSymbol}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCurrencyByTickerSymbol(
            @NotBlank(message = "tickerSymbol->The ticker symbol is required")
            @Size(min = 3, max = 8, message = "tickerSymbol->The ticker symbol must be between 3 and 8 characters")
            @PathVariable String tickerSymbol) {

        currencyService.deleteCurrencyByTickerSymbol(tickerSymbol);
    }

    @GetMapping("/all")
    public Iterable<Currency> getAllCurrencies() {
        return currencyService.findAllCurrencies();
    }

}
