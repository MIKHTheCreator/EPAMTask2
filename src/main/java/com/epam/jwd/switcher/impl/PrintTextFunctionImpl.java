package com.epam.jwd.switcher.impl;

import com.epam.jwd.entity.Text;
import com.epam.jwd.switcher.FunctionExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import static com.epam.jwd.text_handler.TextHandler.printText;
import static com.epam.jwd.view.Menu.getStartMenu;

public class PrintTextFunctionImpl implements FunctionExecutor {

    private static final Logger log = LogManager.getLogger(PrintTextFunctionImpl.class);

    @Override
    public Text execute(Text text) {
        log.info("printText function has been chosen");
        printText(text);
        getStartMenu();
        return text;
    }
}
