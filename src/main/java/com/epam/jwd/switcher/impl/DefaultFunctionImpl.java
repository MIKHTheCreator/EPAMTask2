package com.epam.jwd.switcher.impl;

import com.epam.jwd.entity.Text;
import com.epam.jwd.switcher.FunctionExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Interface implementation for getting default behavior
 * @author Mikhail Kharevich
 */
public class DefaultFunctionImpl implements FunctionExecutor {

    private static final Logger log = LogManager.getLogger(DefaultFunctionImpl.class);

    private static final String WRONG_METHOD_ACCESS = "Choose existed method!";
    private static final String DEFAULT_BLOCK_LOG_MESSAGE = "Default block works...";

    /**
     * {@link FunctionExecutor#execute(Text)}
     * Method provides user with default behavior
     * @param text object to operate with
     * @return text object
     */
    @Override
    public Text execute(Text text) {
        log.info(DEFAULT_BLOCK_LOG_MESSAGE);
        System.out.println(WRONG_METHOD_ACCESS);
        return text;
    }
}
