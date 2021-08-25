package com.epam.jwd.validation;

import java.util.Scanner;

/**
 * Class which keeps inside methods for number validation
 * @author Mikhail Kharevich
 */
public class NumberValidation {

    /**
     * Method for getting input number or default one
     * @param scanner Scanner object
     * @param defaultNumber default number to use
     * @return user's input number if number is input, default number otherwise
     */
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

    /**
     * Method for getting number if it's valid for operation
     * @param inputNumber {@link NumberValidation#getNumberInput(Scanner, int)}
     * @param numberOfSupportedOperations max number of operation which user can choose
     * @param defaultOperation number of default operation
     * @return user input number if it less than (numberOfSupportedOperations - 1), defaultOperation otherwise
     */
    public static int getNumberIfSupported(int inputNumber, int numberOfSupportedOperations, int defaultOperation) {
        if(Math.abs(inputNumber) < numberOfSupportedOperations - 1) {
            return inputNumber;
        } else {
            return defaultOperation;
        }
    }
}
