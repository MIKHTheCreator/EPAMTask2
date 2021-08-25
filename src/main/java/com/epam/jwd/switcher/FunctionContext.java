package com.epam.jwd.switcher;

import com.epam.jwd.entity.impl.Text;
import com.epam.jwd.switcher.api.FunctionExecutor;

import java.util.HashMap;
import java.util.Map;

/**
 * Class which provides user with collection
 * of operations and default methods to interact with collection
 * @author Mikhail Kharevich
 */
public class FunctionContext {

    private Map<Integer, FunctionExecutor> context = new HashMap<>();

    /**
     * Method for registering operation
     * @param operation number of operation(how to reach concrete function)
     * @param function function to execute
     */
    public void register(int operation, FunctionExecutor function) {
        context.put(operation, function);
    }

    /**
     * Method for calling concrete function by its number
     * @param operation number of operation(how to reach concrete function)
     * @param text object on which function is called
     * @return text object
     */
    public Text call(int operation, Text text) {
        return context.get(operation).execute(text);
    }

    /**
     * Method provides user with opportunity to get function by number
     * @param operation number of operation(how to reach concrete function)
     * @return function
     */
    public FunctionExecutor get(int operation) {
        return context.get(operation);
    }

    public int getContextSize() {
        return context.size();
    }
}
