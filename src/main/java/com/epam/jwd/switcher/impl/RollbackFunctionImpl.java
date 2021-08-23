package com.epam.jwd.switcher.impl;

import com.epam.jwd.entity.Text;
import com.epam.jwd.switcher.FunctionExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.epam.jwd.text_handler.TextHandler.rollback;
import static com.epam.jwd.view.Menu.getStartMenu;

public class RollbackFunctionImpl implements FunctionExecutor {

    private static final Logger log = LogManager.getLogger(RollbackFunctionImpl.class);

    @Override
    public Text execute(Text text) {
        log.info("rollback function has been chosen");
        text = rollback(text);
        getStartMenu();
        return text;
    }
}
