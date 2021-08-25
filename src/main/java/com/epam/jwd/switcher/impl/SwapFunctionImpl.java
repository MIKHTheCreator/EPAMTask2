package com.epam.jwd.switcher.impl;

import com.epam.jwd.entity.Text;
import com.epam.jwd.switcher.FunctionExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.epam.jwd.text_handler.TextHandler.swapFirstAndLastWords;
import static com.epam.jwd.view.Menu.getStartMenu;

/**
 * Interface implementation for getting special functional behavior
 * @author Mikhail Kharevich
 */

public class SwapFunctionImpl implements FunctionExecutor {

    private static final Logger log = LogManager.getLogger(SwapFunctionImpl.class);

    private static final String SWAP_FUNCTION_LOG_MESSAGE = "swapFirstAndLastWords function has been chosen";

    /**
     * Method for executing swapFirstAndLastWords function {@link FunctionExecutor#execute(Text)}
     * @param text object to operate with
     * @return modified text object
     */
    @Override
    public Text execute(Text text) {
        log.info(SWAP_FUNCTION_LOG_MESSAGE);
        swapFirstAndLastWords(text);
        getStartMenu();
        return text;
    }
}
