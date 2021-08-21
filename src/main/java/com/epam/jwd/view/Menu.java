package com.epam.jwd.view;

public class Menu {

    private static final String WELCOME_MESSAGE = "===TEXTEDITOR WELCOMES YOU===\n" +
            "/You can choose your own file or take one of our test files\n" +
            "Write 1 or 2 to choose our files or write your file path./";

    public static void printStartMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    public static void getStartMenu() {

    }
}
