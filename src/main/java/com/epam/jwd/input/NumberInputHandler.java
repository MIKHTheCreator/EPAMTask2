package com.epam.jwd.input;

import java.util.Scanner;

/**
 * Class which keeps inside methods for number sorting
 * @author Mikhail Kharevich
 */
public class NumberInputHandler {

    private static final int START_FUNCTION_POSITION = 1;

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
     * @param inputNumber {@link NumberInputHandler#getNumberInput(Scanner, int)}
     * @param numberOfSupportedOperations max number of operation which user can choose
     * @param defaultOperation number of default operation
     * @return user input number if it less than (numberOfSupportedOperations - 1), defaultOperation otherwise
     */
    public static int getNumberIfSupported(int inputNumber, int numberOfSupportedOperations, int defaultOperation) {
        if(isValidNumber(inputNumber, numberOfSupportedOperations)) {
            return inputNumber;
        } else {
            return defaultOperation;
        }
    }

    /**
     * Method for input number validation
     * @param inputNumber users input
     * @param numOfSupportedOperations operations map size
     * @return true if number is valid, false otherwise
     */
    private static boolean isValidNumber(int inputNumber, int numOfSupportedOperations) {
        return (inputNumber < numOfSupportedOperations - 1) && (inputNumber >= START_FUNCTION_POSITION);
    }
}
