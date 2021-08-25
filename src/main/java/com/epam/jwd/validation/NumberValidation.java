package com.epam.jwd.validation;

import java.util.Scanner;

public class NumberValidation {

    public static int getNumberInput(Scanner scanner, int defaultNumber) {
        int inputNumber;

        if (scanner.hasNextInt()) {
            inputNumber = scanner.nextInt();
        } else {
            inputNumber = defaultNumber;
            scanner.next();
        }

        return inputNumber;
    }

    public static int getNumberIfSupported(int inputNumber, int numberOfSupportedOperations, int defaultOperation) {
        if(Math.abs(inputNumber) < numberOfSupportedOperations - 1) {
            return inputNumber;
        } else {
            return defaultOperation;
        }
    }
}
