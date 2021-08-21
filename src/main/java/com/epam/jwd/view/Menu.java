package com.epam.jwd.view;

import com.epam.jwd.entity.Text;
import com.epam.jwd.text_handler.TextHandler;

import java.util.Scanner;

public class Menu {

    private static final String WELCOME_MESSAGE = "===TEXTEDITOR WELCOMES YOU===\n" +
            "/You can choose your own file or take one of our test files\n" +
            "Write 1 or 2 to choose our files or write your file path./";
    private static final String MENU_MESSAGE = "Choose one of supported methods(write a number):\n" +
            "||1-*print text*\n||2-*find number of sentences with equal words*\n||" +
            "3-*get sentences by word increasing*\n||4-*find exclusive word in first sentence*\n||" +
            "5-*exit*";
    private static final String DELIMITER = "/===========================================\\";

    public static void printStartMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    public static void getStartMenu() {
        System.out.println(DELIMITER);
        System.out.println(MENU_MESSAGE);
        System.out.println(DELIMITER);
    }

    public static void exit() {
        System.exit(1);
    }

    public static void runMenu(Text text) {
        getStartMenu();

        Scanner scan = new Scanner(System.in);

        while(scan.hasNext()){
            switch (scan.nextInt()) {
                case 1 -> {
                    TextHandler.printText(text);
                    getStartMenu();
                }
                case 2 -> {
                    System.out.println("Number of sentences with equal words: "
                            + TextHandler.findNumOfSentencesWithEqualsWords(text));
                    getStartMenu();
                }
                case 3 -> {
                    TextHandler.printSentencesByWordIncreasing(text);
                    getStartMenu();
                }
                case 4 -> {
                    System.out.println("Exclusive word: " + TextHandler.findExclusiveWord(text));
                    getStartMenu();
                }
                case 5 -> exit();
                default -> System.out.println("Choose existed method!");
            }
        }
    }
}
