package com.jskno.cryptocoinsbe.web;

import com.jskno.cryptocoinsbe.domain.CryptoCurrencyTransaction;
import com.jskno.cryptocoinsbe.services.CryptoCurrencyTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/api/cryptocurrencytransaction")
@Validated
public class CryptoCurrencyTransactionController {

    @Autowired
    private CryptoCurrencyTransactionService cryptoCurrencyTransactionService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public CryptoCurrencyTransaction createNewCryptoCurrencyTransaction(@Valid @RequestBody CryptoCurrencyTransaction cryptoCurrencyTransaction) {
        return cryptoCurrencyTransactionService.saveOrUpdateCryptoCurrencyTransaction(cryptoCurrencyTransaction);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CryptoCurrencyTransaction cryptoCurrencyTransaction(
            @NotNull(message = "Id is required")
            @Positive(message = "Id must be a positive number")
            @PathVariable Long id) {
        return cryptoCurrencyTransactionService.getCryptoCurrencyTransactionById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCryptoCurrencyTransactionById(
            @NotNull(message = "Id is required")
            @Positive(message = "Id must be a positive number")
            @PathVariable Long id) {

        cryptoCurrencyTransactionService.deleteCryptoCurrencyTransactionById(id);
    }


    @GetMapping("/all")
    public Iterable<CryptoCurrencyTransaction> getAllCryptoCurrencyTransactions() {
        return cryptoCurrencyTransactionService.findAllCryptoCurrencyTranscations();
    }
}
