package com.epam.jwd.switcher.impl;

import com.epam.jwd.entity.Text;
import com.epam.jwd.switcher.FunctionExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.epam.jwd.view.Menu.getStartMenu;

/**
 * Interface implementation for getting special functional behavior
 * @author Mikhail Kharevich
 */
public class WrongInputFunctionImpl implements FunctionExecutor {

    private static final Logger log = LogManager.getLogger(WrongInputFunctionImpl.class);

    private static final String WRONG_INPUT = "You should input number!!!";
    private static final String DEFAULT_OUTPUT_LOG_MESSAGE = "wrongInput function has been chosen";

    /**
     * Method for executing wrongInput function {@link FunctionExecutor#execute(Text)}
     * @param text object to operate with
     * @return text object
     */
    @Override
    public Text execute(Text text) {
        log.info(DEFAULT_OUTPUT_LOG_MESSAGE);
        System.out.println(WRONG_INPUT);
        getStartMenu();
        return text;
    }
}
