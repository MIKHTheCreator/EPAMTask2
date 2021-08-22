package com.epam.jwd.view;

import com.epam.jwd.entity.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

import static com.epam.jwd.text_handler.TextHandler.findExclusiveWord;
import static com.epam.jwd.text_handler.TextHandler.findNumOfSentencesWithEqualsWords;
import static com.epam.jwd.text_handler.TextHandler.getWordsByLength;
import static com.epam.jwd.text_handler.TextHandler.printSentencesByWordIncreasing;
import static com.epam.jwd.text_handler.TextHandler.printText;
import static com.epam.jwd.text_handler.TextHandler.rollback;
import static com.epam.jwd.text_handler.TextHandler.swapFirstAndLastWords;
import static com.epam.jwd.validation.NumberValidation.isNumberInput;

public class Menu {

    private static final Logger log = LogManager.getLogger(Menu.class);

    private static final String WELCOME_MESSAGE = """
            ===TEXTEDITOR WELCOMES YOU===
            /You can choose your own file or take one of our test files
            Write 1 or 2 to choose our files or write your file path./""";
    private static final String MENU_MESSAGE = """
            Choose one of supported methods(write a number):
            ||1-*print text*
            ||2-*find number of sentences with equal words*
            ||3-*get sentences by word increasing*
            ||4-*find exclusive word in first sentence*
            ||5-*print all words of question sentences with given length*
            ||6-*swap first and last words in every sentence*
            ||7-*rollback*
            ||8-*exit*""";
    private static final String DELIMITER = "/===========================================\\";
    private static final int DEFAULT_OPERATION = 0;
    private static final String WRONG_INPUT = "You should input number!!!";
    private static final String WRONG_METHOD_ACCESS = "Choose existed method!";

    public static void printStartMessage() {

        log.info("Printing welcome message");
        System.out.println(WELCOME_MESSAGE);
    }

    public static void getStartMenu() {
        log.info("Printing start menu");
        System.out.println(DELIMITER);
        System.out.println(MENU_MESSAGE);
        System.out.println(DELIMITER);
    }

    public static void exit() {
        log.info("Closing programme...");
        System.exit(1);
    }

    public static void runMenu(Text text) {
        getStartMenu();

        Scanner scan = new Scanner(System.in);
        log.info("Waiting for user message...");

        while (scan.hasNext()) {

           text = chooseOption(isNumberInput(scan, DEFAULT_OPERATION), text);
        }
    }

    private static Text chooseOption(int option, Text text) {
        switch (option) {
            case 0 -> {
                log.info("Default function has been chosen");
                System.out.println(WRONG_INPUT);
                getStartMenu();
            }
            case 1 -> {
                log.info("printText function has been chosen");
                printText(text);
                getStartMenu();
            }
            case 2 -> {
                log.info("getNumOfSentencesWithEqualWords function has been chosen");
                System.out.println("Number of sentences with equal words: "
                        + findNumOfSentencesWithEqualsWords(text));
                getStartMenu();
            }
            case 3 -> {
                log.info("printSentencesByWordIncreasing function has been chosen");
                printSentencesByWordIncreasing(text);
                getStartMenu();
            }
            case 4 -> {
                log.info("findExclusiveWord function has been chosen");
                System.out.println("Exclusive word: " + findExclusiveWord(text));
                getStartMenu();
            }
            case 5 -> {
                log.info("getWordsByLength function has been chosen");
                System.out.println("Words of given length: " + getWordsByLength(text));
                getStartMenu();
            }
            case 6 -> {
                log.info("swapFirstAndLastWords function has been chosen");
                swapFirstAndLastWords(text);
                getStartMenu();
            }
            case 7 -> {
                log.info("rollback function has been chosen");
                text = rollback(text);
                getStartMenu();
            }
            case 8 -> exit();
            default -> {
                log.info("Default block works...");
                System.out.println(WRONG_METHOD_ACCESS);
            }
        }

        return text;
    }
}
