package com.epam.jwd.view;

import com.epam.jwd.entity.Text;
import com.epam.jwd.text_handler.TextHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

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
            ||5-*exit*""";
    private static final String DELIMITER = "/===========================================\\";

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

        while(scan.hasNext()){
            switch (scan.nextInt()) {
                case 1 -> {
                    log.info("printText function has been chosen");
                    TextHandler.printText(text);
                    getStartMenu();
                }
                case 2 -> {
                    log.info("getNumOfSentencesWithEqualWords function has been chosen");
                    System.out.println("Number of sentences with equal words: "
                            + TextHandler.findNumOfSentencesWithEqualsWords(text));
                    getStartMenu();
                }
                case 3 -> {
                    log.info("printSentencesByWordIncreasing function has been chosen");
                    TextHandler.printSentencesByWordIncreasing(text);
                    getStartMenu();
                }
                case 4 -> {
                    log.info("findExclusiveWord function has been chosen");
                    System.out.println("Exclusive word: " + TextHandler.findExclusiveWord(text));
                    getStartMenu();
                }
                case 5 -> exit();
                default -> {
                    log.info("Default block works...");
                    System.out.println("Choose existed method!");
                }
            }
        }
    }
}
