package com.epam.jwd.switcher.impl;

import com.epam.jwd.entity.impl.Text;
import com.epam.jwd.switcher.api.FunctionExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.epam.jwd.text_handler.TextHandler.rollback;
import static com.epam.jwd.view.Menu.getStartMenu;

/**
 * Interface implementation for getting special functional behavior
 * @author Mikhail Kharevich
 */
public class RollbackFunctionImpl implements FunctionExecutor {

    private static final Logger log = LogManager.getLogger(RollbackFunctionImpl.class);

    private static final String ROLLBACK_FUNCTION_LOG_MESSAGE = "rollback function has been chosen";

    /**
     * Method executing rollback function {@link FunctionExecutor#execute(Text)}
     * @param text object to operate with
     * @return not modified text object
     */
    @Override
    public Text execute(Text text) {
        log.info(ROLLBACK_FUNCTION_LOG_MESSAGE);
        text = rollback(text);
        getStartMenu();
        return text;
    }
}
