package com.jskno.cryptocoinsbe.web;

import com.jskno.cryptocoinsbe.domain.ExchangeWeb;
import com.jskno.cryptocoinsbe.services.ExchangeWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exchangeweb")
public class ExchangeWebController {

    @Autowired
    private ExchangeWebService exchangeWebService;

    @PostMapping("")
    public ExchangeWeb createNewExchangeWeb(@RequestBody ExchangeWeb exchangeWeb) {
        return exchangeWebService.saveOrUpdateExchangeWeb(exchangeWeb);
    }
}
