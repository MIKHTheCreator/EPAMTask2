package com.epam.jwd.switcher.impl;

import com.epam.jwd.entity.Text;
import com.epam.jwd.switcher.FunctionExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.epam.jwd.view.Menu.getStartMenu;

public class WrongInputFunctionImpl implements FunctionExecutor {

    private static final Logger log = LogManager.getLogger(WrongInputFunctionImpl.class);

    private static final String WRONG_INPUT = "You should input number!!!";

    @Override
    public Text execute(Text text) {
        log.info("Default function has been chosen");
        System.out.println(WRONG_INPUT);
        getStartMenu();
        return text;
    }
}
