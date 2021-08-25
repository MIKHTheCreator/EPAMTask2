package com.epam.jwd.switcher.impl;

import com.epam.jwd.entity.impl.Text;
import com.epam.jwd.switcher.api.FunctionExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.epam.jwd.text_handler.TextHandler.printSentencesByWordIncreasing;
import static com.epam.jwd.view.Menu.getStartMenu;

/**
 * Interface implementation for getting special functional behavior
 * @author Mikhail Kharevich
 */

public class WordIncreasingFunctionImpl implements FunctionExecutor {

    private static final Logger log = LogManager.getLogger(WordIncreasingFunctionImpl.class);

    private static final String WORD_INCREASING_FUNCTION_LOG_MESSAGE = "printSentencesByWordIncreasing function has been chosen";

    /**
     * Method for executing printSentencesByWordIncreasing function {@link FunctionExecutor#execute(Text)}
     * @param text object to operate with
     * @return text object
     */
    @Override
    public Text execute(Text text) {
        log.info(WORD_INCREASING_FUNCTION_LOG_MESSAGE);
        printSentencesByWordIncreasing(text);
        getStartMenu();
        return text;
    }
}
