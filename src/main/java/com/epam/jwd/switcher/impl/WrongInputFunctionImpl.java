package com.epam.jwd.switcher.impl;

import com.epam.jwd.entity.Text;
import com.epam.jwd.switcher.FunctionExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.epam.jwd.view.Menu.getStartMenu;

public class WrongInputFunctionImpl implements FunctionExecutor {

    private static final Logger log = LogManager.getLogger(WrongInputFunctionImpl.class);

    private static final String WRONG_INPUT = "You should input number!!!";
    private static final String DEFAULT_OUTPUT_LOG_MESSAGE = "Default function has been chosen";

    @Override
    public Text execute(Text text) {
        log.info(DEFAULT_OUTPUT_LOG_MESSAGE);
        System.out.println(WRONG_INPUT);
        getStartMenu();
        return text;
    }
}
