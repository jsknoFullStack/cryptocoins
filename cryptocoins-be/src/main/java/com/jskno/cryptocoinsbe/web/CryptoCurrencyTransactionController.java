package com.jskno.cryptocoinsbe.web;

import com.jskno.cryptocoinsbe.domain.CryptoCurrencyTransaction;
import com.jskno.cryptocoinsbe.services.CryptoCurrencyTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cryptocurrencytransaction")
public class CryptoCurrencyTransactionController {

    @Autowired
    private CryptoCurrencyTransactionService cryptoCurrencyTransactionService;

    @PostMapping("")
    public CryptoCurrencyTransaction createNewCryptoCurrencyTransaction(@RequestBody CryptoCurrencyTransaction cryptoCurrencyTransaction) {
        return cryptoCurrencyTransactionService.saveOrUpdateCryptoCurrencyTransaction(cryptoCurrencyTransaction);
    }

    @GetMapping("")
    public Iterable<CryptoCurrencyTransaction> getAllCryptoCurrencyTransactions() {
        return cryptoCurrencyTransactionService.findAllCryptoCurrencyTranscations();
    }
}
