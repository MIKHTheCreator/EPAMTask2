package com.epam.jwd.switcher.impl;

import com.epam.jwd.entity.Text;
import com.epam.jwd.switcher.FunctionExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.epam.jwd.text_handler.TextHandler.printSentenceWordsInAlphabeticSort;
import static com.epam.jwd.view.Menu.getStartMenu;

/**
 * Interface implementation for getting special functional behavior
 * @author Mikhail Kharevich
 */
public class WordsInAlphabetSortImpl implements FunctionExecutor {

    private static final Logger log = LogManager.getLogger(WordsInAlphabetSortImpl.class);

    private static final String ALPHABETIC_SORT_LOG_MESSAGE = "printWordsInAlphabetSort function has been chosen";

    /**
     * Mehtod for executing printWordsInAlphabetSort function {@link FunctionExecutor#execute(Text)}
     * @param text object to operate with
     * @return text object
     */
    @Override
    public Text execute(Text text) {
        log.info(ALPHABETIC_SORT_LOG_MESSAGE);
        printSentenceWordsInAlphabeticSort(text);
        getStartMenu();
        return text;
    }
}
