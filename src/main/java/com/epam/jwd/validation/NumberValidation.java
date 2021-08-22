package com.epam.jwd.validation;

import java.util.Scanner;

public class NumberValidation {

    public static int isNumberInput(Scanner scanner, int defaultNumber) {
        int inputNumber;

        if(scanner.hasNextInt()){
            inputNumber = scanner.nextInt();
        } else{
            inputNumber = defaultNumber;
            scanner.next();
        }

        return inputNumber;
    }
}
