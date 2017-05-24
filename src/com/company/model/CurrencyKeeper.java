package com.company.model;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CurrencyKeeper {
    private final List<CurrencyAndQuotations> currencyAndQuotationsList;

    public CurrencyKeeper() {
        currencyAndQuotationsList = new ArrayList<CurrencyAndQuotations>();
        currencyAndQuotationsList.add(new CurrencyAndQuotations(CurrencyNames.USD, CurrencyNames.JPY, new BigDecimal("125.42"), new BigDecimal("125.43")));
        currencyAndQuotationsList.add(new CurrencyAndQuotations(CurrencyNames.EUR, CurrencyNames.USD, new BigDecimal("1.2544"), new BigDecimal("1.2545")));
        currencyAndQuotationsList.add(new CurrencyAndQuotations(CurrencyNames.GBP, CurrencyNames.USD, new BigDecimal("14.2842"), new BigDecimal("14.2843")));
        currencyAndQuotationsList.add(new CurrencyAndQuotations(CurrencyNames.AUD, CurrencyNames.USD, new BigDecimal("16.2042"), new BigDecimal("16.8543")));
        currencyAndQuotationsList.add(new CurrencyAndQuotations(CurrencyNames.USD, CurrencyNames.CHF, new BigDecimal("1.3750"), new BigDecimal("1.3754")));
        currencyAndQuotationsList.add(new CurrencyAndQuotations(CurrencyNames.EUR, CurrencyNames.JPY, new BigDecimal("15.2942"), new BigDecimal("15.8543")));
        currencyAndQuotationsList.add(new CurrencyAndQuotations(CurrencyNames.EUR, CurrencyNames.GBP, new BigDecimal("0.6790"), new BigDecimal("0.6794")));
    }

    public List<CurrencyAndQuotations> getCurrencyAndQuotationsList() {
        return currencyAndQuotationsList;
    }

}
