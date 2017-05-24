package com.company;

import java.io.*;
import java.math.BigDecimal;

import static com.company.messages.SystemMessages.ERROR_MESSAGE;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String readFromConsole() {
        String result = "";
        try {
            result = reader.readLine();
        } catch (IOException e) {
            writeToConsole(ERROR_MESSAGE);
        }
        return result;
    }

    public static void writeToConsole(String message) {
        System.out.println(message);
    }

    public static BigDecimal readBigDecFromConsole() {
        BigDecimal result;
        try {
            result = new BigDecimal(readFromConsole());
        } catch (NumberFormatException ex) {
            writeToConsole(ERROR_MESSAGE);
            result = readBigDecFromConsole();
        }
        return result;
    }

    public static int readIntFromConsole() {
        Integer result;
        try {
            result = Integer.parseInt(readFromConsole());
        } catch (NumberFormatException ex) {
            writeToConsole(ERROR_MESSAGE);
            result = readIntFromConsole();
        }
        return result;
    }
}
