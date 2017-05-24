package com.company.controller;


import com.company.model.CurrencyAndQuotations;
import com.company.service.CurrencyService;

import java.math.BigDecimal;
import java.util.List;

public class CurrencyController {
    private CurrencyService currencyService;

    public void setCurrencyService(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    public BigDecimal sell(int id, BigDecimal userValue) {
        return currencyService.sell(id, userValue);
    }

    public BigDecimal buy(int id, BigDecimal userValue) {
        return currencyService.buy(id, userValue);
    }

    public List<CurrencyAndQuotations> listOfCurrency() {
        return currencyService.listOfCurrency();
    }

    public CurrencyAndQuotations getCurrencyById(int id) {
        return currencyService.getCurrencyById(id);
    }
}
