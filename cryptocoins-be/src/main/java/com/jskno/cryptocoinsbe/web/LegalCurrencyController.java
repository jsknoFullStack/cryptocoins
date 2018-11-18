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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@RequestMapping("/api/legalcurrency")
@Validated
public class LegalCurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Currency createNewCurrency(@Valid @RequestBody LegalCurrency currency) {
        return currencyService.saveOrUpdateCurrency(currency);
    }

}
