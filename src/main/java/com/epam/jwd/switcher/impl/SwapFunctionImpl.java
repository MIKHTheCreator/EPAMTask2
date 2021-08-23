package com.epam.jwd.switcher.impl;

import com.epam.jwd.entity.Text;
import com.epam.jwd.switcher.FunctionExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.epam.jwd.text_handler.TextHandler.swapFirstAndLastWords;
import static com.epam.jwd.view.Menu.getStartMenu;

public class SwapFunctionImpl implements FunctionExecutor {

    private static final Logger log = LogManager.getLogger(SwapFunctionImpl.class);

    @Override
    public Text execute(Text text) {
        log.info("swapFirstAndLastWords function has been chosen");
        swapFirstAndLastWords(text);
        getStartMenu();
        return text;
    }
}
