package com.epam.jwd.switcher.impl;

import com.epam.jwd.entity.Text;
import com.epam.jwd.switcher.FunctionExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.epam.jwd.text_handler.TextHandler.rollback;
import static com.epam.jwd.view.Menu.getStartMenu;

public class RollbackFunctionImpl implements FunctionExecutor {

    private static final Logger log = LogManager.getLogger(RollbackFunctionImpl.class);

    private static final String ROLLBACK_FUNCTION_LOG_MESSAGE = "rollback function has been chosen";

    @Override
    public Text execute(Text text) {
        log.info(ROLLBACK_FUNCTION_LOG_MESSAGE);
        text = rollback(text);
        getStartMenu();
        return text;
    }
}
