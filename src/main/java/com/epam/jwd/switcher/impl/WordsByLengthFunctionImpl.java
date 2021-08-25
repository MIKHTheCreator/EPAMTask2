package com.epam.jwd.switcher.impl;

import com.epam.jwd.entity.impl.Text;
import com.epam.jwd.switcher.api.FunctionExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.epam.jwd.text_handler.TextHandler.getWordsByLength;
import static com.epam.jwd.view.Menu.getStartMenu;

/**
 * Interface implementation for getting special functional behavior
 * @author Mikhail Kharevich
 */

public class WordsByLengthFunctionImpl implements FunctionExecutor {

    private static final Logger log = LogManager.getLogger(WordsByLengthFunctionImpl.class);

    private static final String GIVEN_LENGTH_WORDS = "Words of given length: ";
    private static final String WORDS_BY_LENGTH_LOG_MESSAGE = "getWordsByLength function has been chosen";

    /**
     * Method for executing getWordsByLength function {@link FunctionExecutor#execute(Text)}
     * @param text object to operate with
     * @return text object
     */
    @Override
    public Text execute(Text text) {
        log.info(WORDS_BY_LENGTH_LOG_MESSAGE);
        System.out.println(GIVEN_LENGTH_WORDS + getWordsByLength(text));
        getStartMenu();
        return text;
    }
}
