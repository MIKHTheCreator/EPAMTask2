package com.epam.jwd.switcher.impl;

import com.epam.jwd.entity.impl.Text;
import com.epam.jwd.switcher.api.FunctionExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.epam.jwd.text_handler.TextHandler.findExclusiveWord;
import static com.epam.jwd.view.Menu.getStartMenu;

/**
 * Interface implementation for getting special functional behavior
 * @author Mikhail Kharevich
 */
public class ExclusiveWordFunctionImpl implements FunctionExecutor {

    private static final Logger log = LogManager.getLogger(ExclusiveWordFunctionImpl.class);

    private static final String EXCLUSIVE_WORD = "Exclusive word: ";
    private static final String EXCLUSIVE_WORD_FUNCTION_LOG_MESSAGE = "findExclusiveWord function has been chosen";

    /**
     * Method for executing findExclusiveWord function {@link FunctionExecutor#execute(Text)}
     * @param text object to operate with
     * @return text object
     */
    @Override
    public Text execute(Text text) {
        log.info(EXCLUSIVE_WORD_FUNCTION_LOG_MESSAGE);
        System.out.println(EXCLUSIVE_WORD + findExclusiveWord(text));
        getStartMenu();
        return text;
    }
}
