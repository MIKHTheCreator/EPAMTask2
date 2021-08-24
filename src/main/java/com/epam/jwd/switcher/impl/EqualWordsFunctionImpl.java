package com.epam.jwd.switcher.impl;

import com.epam.jwd.entity.Text;
import com.epam.jwd.switcher.FunctionExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.epam.jwd.text_handler.TextHandler.findNumOfSentencesWithEqualsWords;
import static com.epam.jwd.view.Menu.getStartMenu;

public class EqualWordsFunctionImpl implements FunctionExecutor {

    private static final Logger log = LogManager.getLogger(EqualWordsFunctionImpl.class);

    private static final String SENTENCE_INCREASING = "Number of sentences with equal words: ";
    private static final String EQUAL_WORDS_FUNCTION_LOG_MESSAGE = "getNumOfSentencesWithEqualWords function has been chosen";

    @Override
    public Text execute(Text text) {
        log.info(EQUAL_WORDS_FUNCTION_LOG_MESSAGE);
        System.out.println(SENTENCE_INCREASING
                + findNumOfSentencesWithEqualsWords(text));
        getStartMenu();
        return text;
    }
}
