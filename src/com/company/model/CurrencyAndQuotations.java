package com.company.model;

import javax.annotation.Nonnull;
import java.math.BigDecimal;


public class CurrencyAndQuotations {
    private final CurrencyNames firstCurrency;
    private final CurrencyNames secondCurrency;
    private final BigDecimal bid;
    private final BigDecimal ask;


    public CurrencyAndQuotations(@Nonnull CurrencyNames firstCurrency,
                                 @Nonnull CurrencyNames secondCurrency,
                                 @Nonnull BigDecimal bid,
                                 @Nonnull BigDecimal ask) {
        this.firstCurrency = firstCurrency;
        this.secondCurrency = secondCurrency;
        this.bid = bid;
        this.ask = ask;
    }

    public String getNameCurrency() {
        return firstCurrency + "/" + secondCurrency;
    }

    public BigDecimal getBid() {
        return bid;
    }

    public BigDecimal getAsk() {
        return ask;
    }

    @Override
    public String toString() {
        return "Валютная пара = " + firstCurrency +
                "/" + secondCurrency +
                ", покупка=" + bid +
                ", продажа=" + ask;
    }
}
