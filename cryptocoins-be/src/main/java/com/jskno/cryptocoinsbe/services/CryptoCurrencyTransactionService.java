package com.jskno.cryptocoinsbe.services;

import com.jskno.cryptocoinsbe.domain.CryptoCurrencyTransaction;
import com.jskno.cryptocoinsbe.exceptions.EntityNotFoundException;
import com.jskno.cryptocoinsbe.repositories.CryptoCurrencyTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.Optional;

@Service
public class CryptoCurrencyTransactionService {

    @Autowired
    private CryptoCurrencyTransactionRepository cryptoCurrencyTransactionRepository;

    public CryptoCurrencyTransaction saveOrUpdateCryptoCurrencyTransaction(
            CryptoCurrencyTransaction cryptoCurrencyTransaction) {
        return cryptoCurrencyTransactionRepository.save(cryptoCurrencyTransaction);
    }

    public CryptoCurrencyTransaction getCryptoCurrencyTransactionById(Long id) {
        Optional<CryptoCurrencyTransaction> cryptoCurrencyTransaction = cryptoCurrencyTransactionRepository.findById(id);
        return cryptoCurrencyTransaction.orElseThrow(
                () -> new EntityNotFoundException("cryptoCurrencyTransactionId", new StringBuilder()
                .append("Cannot find CryptoCurrency Transaction with ID '")
                .append(id)
                .append("'. This transaction does not exist").toString()));
    }

    public void deleteCryptoCurrencyTransactionById(Long id) {
        Optional<CryptoCurrencyTransaction> cryptoCurrencyTransaction = cryptoCurrencyTransactionRepository.findById(id);
        if(cryptoCurrencyTransaction.isPresent()) {
            throw new EntityNotFoundException("cryptoCurrencyTransactionId", new StringBuilder()
                    .append("Cannot delete CryptoCurrency Transaction with ID '")
                    .append(id)
                    .append("'. This transaction does not exist").toString());
        }
        cryptoCurrencyTransactionRepository.delete(cryptoCurrencyTransaction.get());
    }

    public Iterable<CryptoCurrencyTransaction> findAllCryptoCurrencyTranscations() {
        return cryptoCurrencyTransactionRepository.findAll();
    }

}
