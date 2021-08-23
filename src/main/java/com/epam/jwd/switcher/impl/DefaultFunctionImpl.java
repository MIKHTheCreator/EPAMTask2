package com.epam.jwd.switcher.impl;

import com.epam.jwd.entity.Text;
import com.epam.jwd.switcher.FunctionExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DefaultFunctionImpl implements FunctionExecutor {

    private static final Logger log = LogManager.getLogger(DefaultFunctionImpl.class);

    private static final String WRONG_METHOD_ACCESS = "Choose existed method!";

    @Override
    public Text execute(Text text) {
        log.info("Default block works...");
        System.out.println(WRONG_METHOD_ACCESS);
        return text;
    }
}
