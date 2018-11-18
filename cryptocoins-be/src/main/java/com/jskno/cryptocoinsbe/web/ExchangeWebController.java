package com.jskno.cryptocoinsbe.web;

import com.jskno.cryptocoinsbe.domain.ExchangeWeb;
import com.jskno.cryptocoinsbe.services.ExchangeWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Optional;

@RestController
@RequestMapping("/api/exchangeweb")
@Validated
public class ExchangeWebController {

    @Autowired
    private ExchangeWebService exchangeWebService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ExchangeWeb createNewExchangeWeb(@Valid @RequestBody ExchangeWeb exchangeWeb) {
        return exchangeWebService.saveOrUpdateExchangeWeb(exchangeWeb);
    }

    @GetMapping("/{exchangeWebId}")
    @ResponseStatus(HttpStatus.OK)
    public ExchangeWeb exchangeWeb(
            @NotNull(message = "exchangeWebId->The id is required")
            @Positive(message = "exchangeWebId->The id must be a positive number")
            @PathVariable Long exchangeWebId) {
        return exchangeWebService.getExchangeWebById(exchangeWebId);
    }

    @DeleteMapping("/{exchangeWebId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteExchangeWeb(
            @NotNull(message = "exchangeWebId->The id is required")
            @Positive(message = "exchangeWebId->The id must be a positive number")
            @PathVariable Long exchangeWebId) {
        exchangeWebService.deleteExchangeWebById(exchangeWebId);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<ExchangeWeb> getAllExchangeWebs() {
        return exchangeWebService.findAllExchangeWebs();
    }

}
