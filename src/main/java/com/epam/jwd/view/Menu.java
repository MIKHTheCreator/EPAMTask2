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
    private static final String WELCOME_LOG_MESSAGE = "Printing welcome message";
    private static final String CLOSE_PROGRAMME_LOG_MESSAGE = "Closing programme...";
    private static final String USER_INPUT_LOG_MESSAGE = "Waiting for user's input...";
    private static final int DEFAULT_OPERATION = 0;

    private static FunctionContext functionContext = new FunctionContext();

    static {
        functionContext.register(0, new WrongInputFunctionImpl());
        functionContext.register(1, new PrintTextFunctionImpl());
        functionContext.register(2, new EqualWordsFunctionImpl());
        functionContext.register(3, new WordIncreasingFunctionImpl());
        functionContext.register(4, new ExclusiveWordFunctionImpl());
        functionContext.register(5, new WordsByLengthFunctionImpl());
        functionContext.register(6, new SwapFunctionImpl());
        functionContext.register(7, new WordsInAlphabetSortImpl());
        functionContext.register(8, new RollbackFunctionImpl());
        functionContext.register(9, new ExitFunctionImpl());
    }

    public static void printStartMessage() {

        log.info(WELCOME_LOG_MESSAGE);
        System.out.println(WELCOME_MESSAGE);
    }

    public static void getStartMenu() {
        System.out.println(DELIMITER);
        System.out.println(MENU_MESSAGE);
        System.out.println(DELIMITER);
    }

    public static void exit() {
        log.info(CLOSE_PROGRAMME_LOG_MESSAGE);
        System.exit(1);
    }

    public static void runMenu(Text text) {
        getStartMenu();

        Scanner scan = new Scanner(System.in);
        log.info(USER_INPUT_LOG_MESSAGE);

        while (scan.hasNext()) {

            text = functionContext.call(getNumberInput(scan, DEFAULT_OPERATION), text);
        }
    }

}
