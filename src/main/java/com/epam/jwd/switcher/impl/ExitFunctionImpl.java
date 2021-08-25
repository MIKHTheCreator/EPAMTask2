package com.epam.jwd.switcher.impl;

import com.epam.jwd.entity.Text;
import com.epam.jwd.switcher.FunctionExecutor;
import com.epam.jwd.view.Menu;

import static com.epam.jwd.view.Menu.exit;

/**
 * Interface implementation for getting special functional behavior
 * @author Mikhail Kharevich
 */
public class ExitFunctionImpl implements FunctionExecutor {

    /**
     * Method for executing exit function {@link Menu#exit()}
     * {@link FunctionExecutor#execute(Text)}
     * @param text object to operate with
     */
    @Override
    public Text execute(Text text) {
        exit();
        return text;
    }
}
