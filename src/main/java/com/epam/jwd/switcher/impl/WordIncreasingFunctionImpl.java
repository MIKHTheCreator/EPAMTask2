package com.epam.jwd.switcher.impl;

import com.epam.jwd.entity.Text;
import com.epam.jwd.switcher.FunctionExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.epam.jwd.text_handler.TextHandler.printSentencesByWordIncreasing;
import static com.epam.jwd.view.Menu.getStartMenu;

public class WordIncreasingFunctionImpl implements FunctionExecutor {

    private static final Logger log = LogManager.getLogger(WordIncreasingFunctionImpl.class);

    private static final String WORD_INCREASING_FUNCTION_LOG_MESSAGE = "printSentencesByWordIncreasing function has been chosen";

    @Override
    public Text execute(Text text) {
        log.info(WORD_INCREASING_FUNCTION_LOG_MESSAGE);
        printSentencesByWordIncreasing(text);
        getStartMenu();
        return text;
    }
}