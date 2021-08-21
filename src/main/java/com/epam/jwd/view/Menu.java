package com.epam.jwd.view;

public class Menu {

    private static final String WELCOME_MESSAGE = "===TEXTEDITOR WELCOMES YOU===\n" +
            "/You can choose your own file or take one of our test files\n" +
            "Write 1 or 2 to choose our files or write your file path./";
    private static final String MENU_MESSAGE = "Choose one of supported methods(write a number):\n" +
            "1-*print text*||2-*find number of sentences with equal words*\n" +
            "3-*get sentences by word increasing*||4-*find exclusive word in first sentence*\n" +
            "5-*exit*";
    public static final String DELIMITER = "/===========================================\\";

    public static void printStartMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    public static void getStartMenu() {
        System.out.println(DELIMITER);
        System.out.println(MENU_MESSAGE);
        System.out.println(DELIMITER);
    }

    public static void exit(){
        System.exit(1);
    }
}
