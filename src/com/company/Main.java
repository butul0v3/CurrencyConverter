package com.company;

import com.company.controller.CurrencyController;
import com.company.model.CurrencyKeeper;
import com.company.service.CurrencyServiceImpl;
import com.company.view.View;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        CurrencyController currencyController = new CurrencyController();
        CurrencyKeeper currencyKeeper = new CurrencyKeeper();
        CurrencyServiceImpl service = new CurrencyServiceImpl();
        service.setCurrencyKeeper(currencyKeeper);
        currencyController.setCurrencyService(service);
        view.setController(currencyController);
        view.welcomeScreen();
    }
}
