package com.jskno.cryptocoinsbe.repositories;

import com.jskno.cryptocoinsbe.domain.ExchangeWeb;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeWebRepository extends CrudRepository<ExchangeWeb, Long> {
}
