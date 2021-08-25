package com.epam.jwd.switcher.impl;

import com.epam.jwd.entity.impl.Text;
import com.epam.jwd.switcher.api.FunctionExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import static com.epam.jwd.text_handler.TextHandler.printText;
import static com.epam.jwd.view.Menu.getStartMenu;

/**
 * Interface implementation for getting special functional behavior
 * @author Mikhail Kharevich
 */
public class PrintTextFunctionImpl implements FunctionExecutor {

    private static final Logger log = LogManager.getLogger(PrintTextFunctionImpl.class);

    private static final String PRINT_TEXT_FUNCTION_LOG_MESSAGE = "printText function has been chosen";

    /**
     * Method for executing printText function {@link FunctionExecutor#execute(Text)}
     * @param text object to operate with
     * @return text object
     */
    @Override
    public Text execute(Text text) {
        log.info(PRINT_TEXT_FUNCTION_LOG_MESSAGE);
        printText(text);
        getStartMenu();
        return text;
    }
}
