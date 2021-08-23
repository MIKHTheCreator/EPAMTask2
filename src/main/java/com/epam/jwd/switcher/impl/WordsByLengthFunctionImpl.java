package com.epam.jwd.switcher.impl;

import com.epam.jwd.entity.Text;
import com.epam.jwd.switcher.FunctionExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.epam.jwd.text_handler.TextHandler.getWordsByLength;
import static com.epam.jwd.view.Menu.getStartMenu;

public class WordsByLengthFunctionImpl implements FunctionExecutor {

    private static final Logger log = LogManager.getLogger(WordsByLengthFunctionImpl.class);

    private static final String GIVEN_LENGTH_WORDS = "Words of given length: ";

    @Override
    public Text execute(Text text) {
        log.info("getWordsByLength function has been chosen");
        System.out.println(GIVEN_LENGTH_WORDS + getWordsByLength(text));
        getStartMenu();
        return text;
    }
}
