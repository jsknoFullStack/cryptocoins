//@formatter:off
/**
 *  $$Id$$
 *       . * .
 *     * RRRR  *    Copyright (c) 2018 EUIPO: European Union Intellectual
 *   .   RR  R   .  Property Office (trade marks and designs)
 *   *   RRR     *
 *    .  RR RR  .   ALL RIGHTS RESERVED
 *     * . _ . *
 */
//@formatter:on
package com.jskno.cryptocoinsbe.domain;

import com.jskno.cryptocoinsbe.domain.enums.TransactionType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.util.Date;

@Entity
@Table(name = "cryptocurrency_transaction")
public class CryptoCurrencyTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "transaction_type")
    @NotNull(message = "The transacion type is required")
    private TransactionType transactionType;

    @ManyToOne
    @JoinColumn(name = "cryptocurrency_id")
    @NotNull(message = "Every Transaction must be associated to a CryptoCurrency")
    private CryptoCurrency cryptoCurrency;

    @Column(name = "units")
    @Positive(message = "Units must be positive number")
    private Double units;

    @ManyToOne
    @JoinColumn(name = "transaction_currency_id")
    @NotNull(message = "Currency though which the CrypoCurrency was paid must be informed")
    private Currency transactionCurrency;

    @Column(name = "transaction_price")
    @Positive
    private Double transactionPrice;

    // How many euros worth a unit of purchaseCurrency
    @Column(name = "euros_transaction_currency_rate")
    @Positive
    private Double eurosTransactionCurrencyRate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "transaction_date")
    @PastOrPresent(message = "None transaction can take place in the future")
    private Date transactionDate;

    @ManyToOne
    @JoinColumn(name = "exchangeWebId")
    @NotNull(message = "The ExchangeWeb is required")
    private ExchangeWeb exchangeWeb;

    public CryptoCurrencyTransaction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public CryptoCurrency getCryptoCurrency() {
        return cryptoCurrency;
    }

    public void setCryptoCurrency(CryptoCurrency cryptoCurrency) {
        this.cryptoCurrency = cryptoCurrency;
    }

    public Double getUnits() {
        return units;
    }

    public void setUnits(Double units) {
        this.units = units;
    }

    public Currency getTransactionCurrency() {
        return transactionCurrency;
    }

    public void setTransactionCurrency(Currency transactionCurrency) {
        this.transactionCurrency = transactionCurrency;
    }

    public Double getTransactionPrice() {
        return transactionPrice;
    }

    public void setTransactionPrice(Double transactionPrice) {
        this.transactionPrice = transactionPrice;
    }

    public Double getEurosTransactionCurrencyRate() {
        return eurosTransactionCurrencyRate;
    }

    public void setEurosTransactionCurrencyRate(Double eurosTransactionCurrencyRate) {
        this.eurosTransactionCurrencyRate = eurosTransactionCurrencyRate;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public ExchangeWeb getExchangeWeb() {
        return exchangeWeb;
    }

    public void setExchangeWeb(ExchangeWeb exchangeWeb) {
        this.exchangeWeb = exchangeWeb;
    }
}
