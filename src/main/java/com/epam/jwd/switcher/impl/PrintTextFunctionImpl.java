package com.epam.jwd.switcher.impl;

import com.epam.jwd.entity.Text;
import com.epam.jwd.switcher.FunctionExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import static com.epam.jwd.text_handler.TextHandler.printText;
import static com.epam.jwd.view.Menu.getStartMenu;

public class PrintTextFunctionImpl implements FunctionExecutor {

    private static final Logger log = LogManager.getLogger(PrintTextFunctionImpl.class);

    private static final String PRINT_TEXT_FUNCTION_LOG_MESSAGE = "printText function has been chosen";

    @Override
    public Text execute(Text text) {
        log.info(PRINT_TEXT_FUNCTION_LOG_MESSAGE);
        printText(text);
        getStartMenu();
        return text;
    }
}
