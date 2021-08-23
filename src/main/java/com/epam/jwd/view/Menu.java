package com.epam.jwd.view;

import com.epam.jwd.entity.Text;
import com.epam.jwd.switcher.FunctionContext;
import com.epam.jwd.switcher.impl.EqualWordsFunctionImpl;
import com.epam.jwd.switcher.impl.ExclusiveWordFunctionImpl;
import com.epam.jwd.switcher.impl.ExitFunctionImpl;
import com.epam.jwd.switcher.impl.PrintTextFunctionImpl;
import com.epam.jwd.switcher.impl.RollbackFunctionImpl;
import com.epam.jwd.switcher.impl.SwapFunctionImpl;
import com.epam.jwd.switcher.impl.WordIncreasingFunctionImpl;
import com.epam.jwd.switcher.impl.WordsByLengthFunctionImpl;
import com.epam.jwd.switcher.impl.WordsInAlphabetSortImpl;
import com.epam.jwd.switcher.impl.WrongInputFunctionImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

import static com.epam.jwd.validation.NumberValidation.getNumberInput;

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
            ||7-*print words in alphabet sort*
            ||8-*rollback*
            ||9-*exit*""";
    private static final String DELIMITER = "/===========================================\\";
    private static final int DEFAULT_OPERATION = 0;

    private static FunctionContext context = new FunctionContext();

    static {
        context.register(0, new WrongInputFunctionImpl());
        context.register(1, new PrintTextFunctionImpl());
        context.register(2, new EqualWordsFunctionImpl());
        context.register(3, new WordIncreasingFunctionImpl());
        context.register(4, new ExclusiveWordFunctionImpl());
        context.register(5, new WordsByLengthFunctionImpl());
        context.register(6, new SwapFunctionImpl());
        context.register(7, new WordsInAlphabetSortImpl());
        context.register(8, new RollbackFunctionImpl());
        context.register(9, new ExitFunctionImpl());
    }

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
        log.info("Waiting for user's input...");

        while (scan.hasNext()) {

           text = context.call(getNumberInput(scan, DEFAULT_OPERATION), text);
        }
    }

}
