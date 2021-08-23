package com.epam.jwd.switcher.impl;

import com.epam.jwd.entity.Text;
import com.epam.jwd.switcher.FunctionExecutor;

import static com.epam.jwd.view.Menu.exit;

public class ExitFunctionImpl implements FunctionExecutor {

    @Override
    public Text execute(Text text) {
        exit();
        return text;
    }
}
