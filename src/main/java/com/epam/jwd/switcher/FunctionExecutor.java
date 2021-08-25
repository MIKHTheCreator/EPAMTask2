package com.epam.jwd.switcher;

import com.epam.jwd.entity.Text;

/**
 * Interface which provides switcher classes with common behave
 * @author Mikhail Kharevich
 */
public interface FunctionExecutor {

    /**
     * Method for executing one operation
     * @param text object to operate with
     * @return text object
     */
    Text execute(Text text);
}
