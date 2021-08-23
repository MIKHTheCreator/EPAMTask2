package com.epam.jwd.switcher.impl;

import com.epam.jwd.entity.Text;
import com.epam.jwd.switcher.FunctionExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.epam.jwd.text_handler.TextHandler.printSentenceWordsInAlphabeticSort;
import static com.epam.jwd.view.Menu.getStartMenu;

public class WordsInAlphabetSortImpl implements FunctionExecutor {

    private static final Logger log = LogManager.getLogger(WordsInAlphabetSortImpl.class);

    @Override
    public Text execute(Text text) {
        log.info("printWordsInAlphabetSort function has been chosen");
        printSentenceWordsInAlphabeticSort(text);
        getStartMenu();
        return text;
    }
}
