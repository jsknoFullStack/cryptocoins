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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity
@Table(name = "cryptocurrency_transaction")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CryptoCurrencyTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "transaction_type")
    private TransactionType transactionType;

    @ManyToOne
    @JoinColumn(name = "cryptocurrency_id")
    private CryptoCurrency cryptoCurrency;

    @Column(name = "units")
    private Double units;

    @ManyToOne
    @JoinColumn(name = "transaction_currency_id")
    private Currency transactionCurrency;

    @Column(name = "transaction_price")
    private Double transactionPrice;

    // How many euros worth a unit of purchaseCurrency
    @Column(name = "euros_transaction_currency_rate")
    private Double eurosTransactionCurrencyRate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "transaction_date")
    private Date transactionDate;

    @ManyToOne
    @JoinColumn(name = "exchangeWebId")
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
