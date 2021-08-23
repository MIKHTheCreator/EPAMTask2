package com.epam.jwd.switcher;

import com.epam.jwd.entity.Text;

import java.util.HashMap;
import java.util.Map;

public class FunctionContext {

    private Map<Integer, FunctionExecutor> context = new HashMap<>();

    public void register(int operation, FunctionExecutor function) {
        context.put(operation, function);
    }

    public Text call(int operation, Text text) {
        return context.get(operation).execute(text);
    }

    public FunctionExecutor get(int operation) {
        return context.get(operation);
    }
}
