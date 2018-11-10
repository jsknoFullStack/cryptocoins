package com.jskno.cryptocoinsbe.services;

import com.jskno.cryptocoinsbe.domain.CryptoCurrencyTransaction;
import com.jskno.cryptocoinsbe.repositories.CryptoCurrencyTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CryptoCurrencyTransactionService {

    @Autowired
    private CryptoCurrencyTransactionRepository cryptoCurrencyTransactionRepository;

    public CryptoCurrencyTransaction saveOrUpdateCryptoCurrencyTransaction(CryptoCurrencyTransaction cryptoCurrencyTransaction) {
        return cryptoCurrencyTransactionRepository.save(cryptoCurrencyTransaction);
    }

    public Iterable<CryptoCurrencyTransaction> findAllCryptoCurrencyTranscations() {
        return cryptoCurrencyTransactionRepository.findAll();
    }

}
