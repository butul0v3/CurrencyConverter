package com.company.view;


import com.company.ConsoleHelper;
import com.company.controller.CurrencyController;
import com.company.model.CurrencyAndQuotations;

import java.math.BigDecimal;
import java.util.List;

import static com.company.messages.SystemMessages.*;

public class View {
    private CurrencyController controller;
    private List<CurrencyAndQuotations> currencyAndQuotationsList;


    public void setController(CurrencyController controller) {
        this.controller = controller;
        currencyAndQuotationsList = controller.listOfCurrency();
    }

    public void welcomeScreen() {
        ConsoleHelper.writeToConsole(WELCOME);
        int i = 0;

        for (CurrencyAndQuotations currencyAndQuotations : currencyAndQuotationsList) {
            ConsoleHelper.writeToConsole(i++ + ". " + currencyAndQuotations.toString());
        }

        ConsoleHelper.writeToConsole(i + ". Выход из программы\n" +
                "_________________________________________________________________\n" +
                "Выберите валюту, которую хотели бы купить\\продать (от 0 до " + (currencyAndQuotationsList.size() - 1) + ")");

        int userChoice = ConsoleHelper.readIntFromConsole();

        if (userChoice < 0 || userChoice > currencyAndQuotationsList.size()) {
            ConsoleHelper.writeToConsole("Не найдено валютной пары с таким номером, повторите, пожалуйста, ввод");
            welcomeScreen();
        } else if (userChoice == currencyAndQuotationsList.size()) {
            askForExit();
        } else sellOrByCurrency(userChoice);
    }

    private void askForExit() {
        ConsoleHelper.writeToConsole(ASK_FOR_EXIT);
        int userChoice = ConsoleHelper.readIntFromConsole();
        switch (userChoice) {
            case 1:
                ConsoleHelper.writeToConsole(GOODBYE);
                System.exit(1);
            case 2:
                welcomeScreen();
                break;
            default:
                ConsoleHelper.writeToConsole(NOT_FOUND_OPERATION);
                askForExit();
        }
    }

    private void askForRepeat() {
        ConsoleHelper.writeToConsole(ASK_FOR_REPEAT);
        int userChoice = ConsoleHelper.readIntFromConsole();
        switch (userChoice) {
            case 1:
                break;
            case 2:
                welcomeScreen();
                break;
            case 3:
                askForExit();
                break;
            default:
                ConsoleHelper.writeToConsole(NOT_FOUND_OPERATION);
                askForRepeat();
                break;
        }
    }

    private void sellOrByCurrency(int prevUserChoice) {
        CurrencyAndQuotations currency = controller.getCurrencyById(prevUserChoice);
        String[] currencyPair = currency.getNameCurrency().split("/");
        String part1 = currencyPair[0];
        String part2 = currencyPair[1];

        ConsoleHelper.writeToConsole("_________________________________________________________________\n" +
                "Выбрана: " + currency.toString() +
                "\n_________________________________________________________________");

        ConsoleHelper.writeToConsole("Выберите операцию, которую хотели бы совершить:\n" +
                "_________________________________________________________________\n" +
                "1. Купить " + part1 + " продать " + part2 + "\n" +
                "2. Купить " + part2 + " продать " + part1 + "\n" +
                "3. Вернуться назад");
        int userChoise;
        do {
            userChoise = ConsoleHelper.readIntFromConsole();
            if (userChoise < 1 || userChoise > 3) ConsoleHelper.writeToConsole(NOT_FOUND_OPERATION);
        } while (userChoise < 1 || userChoise > 3);

        if (userChoise == 3) welcomeScreen();
        else if (userChoise == 1) dealForBuy(prevUserChoice, part1, part2);
        else if (userChoise == 2) dealForSell(prevUserChoice, part2, part1);
    }

    private void dealForSell(int prevUserChoise, String part1, String part2) {
        ConsoleHelper.writeToConsole(String.format(DEAL, part1, part2, part1));
        BigDecimal bigDecimal = ConsoleHelper.readBigDecFromConsole();
        ConsoleHelper.writeToConsole("Для получения " + bigDecimal + " " + part1 + " вам понадобится " + controller.sell(prevUserChoise, bigDecimal).toString() + " " + part2);
        askForRepeat();
        dealForSell(prevUserChoise, part1, part2);
    }

    private void dealForBuy(int prevUserChoise, String part1, String part2) {
        ConsoleHelper.writeToConsole(String.format(DEAL, part1, part2, part1));
        BigDecimal bigDecimal = ConsoleHelper.readBigDecFromConsole();
        ConsoleHelper.writeToConsole("Для получения " + bigDecimal + " " + part1 + " вам понадобится " + controller.buy(prevUserChoise, bigDecimal).toString() + " " + part2);
        askForRepeat();
        dealForBuy(prevUserChoise, part1, part2);
    }
}
