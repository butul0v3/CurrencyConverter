package com.company.service;


import com.company.model.CurrencyAndQuotations;

import java.math.BigDecimal;
import java.util.List;

public interface CurrencyService {
    BigDecimal sell(int id, BigDecimal userValue);
    BigDecimal buy(int id, BigDecimal userValue);
    List<CurrencyAndQuotations> listOfCurrency();
    CurrencyAndQuotations getCurrencyById(int id);
}
