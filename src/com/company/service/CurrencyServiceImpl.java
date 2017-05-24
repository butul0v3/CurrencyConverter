package com.company.service;


import com.company.model.CurrencyAndQuotations;
import com.company.model.CurrencyKeeper;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class CurrencyServiceImpl implements CurrencyService {
    private CurrencyKeeper currencyKeeper;
    private final int DIGITS_AFTER_COMMA = 2;

    public void setCurrencyKeeper(CurrencyKeeper currencyKeeper) {
        this.currencyKeeper = currencyKeeper;
    }

    @Override
    public BigDecimal sell(int id, BigDecimal userValue) {
        CurrencyAndQuotations currency = getCurrencyById(id);
        BigDecimal bid = currency.getBid();
        return userValue.divide(bid, DIGITS_AFTER_COMMA, BigDecimal.ROUND_HALF_EVEN).setScale(DIGITS_AFTER_COMMA, RoundingMode.HALF_EVEN);
    }

    @Override
    public BigDecimal buy(int id, BigDecimal userValue) {
        CurrencyAndQuotations currency = getCurrencyById(id);
        BigDecimal ask = currency.getAsk();
        return ask.multiply(userValue).setScale(DIGITS_AFTER_COMMA, BigDecimal.ROUND_HALF_EVEN);
    }

    @Override
    public List<CurrencyAndQuotations> listOfCurrency() {
        return currencyKeeper.getCurrencyAndQuotationsList();
    }

    @Override
    public CurrencyAndQuotations getCurrencyById(int id) {
        return currencyKeeper.getCurrencyAndQuotationsList().get(id);
    }
}
