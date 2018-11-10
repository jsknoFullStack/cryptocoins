package com.jskno.cryptocoinsbe.repositories;

import com.jskno.cryptocoinsbe.domain.CryptoCurrencyTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptoCurrencyTransactionRepository extends CrudRepository<CryptoCurrencyTransaction, Long> {
}
