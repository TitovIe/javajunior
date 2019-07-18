package com.acme.edu.Decorator;

public class DecoratorObject implements Decorator {
    @Override
    public String getDecorString(Object message) throws Exception {
        if (message == null) {
            return "reference: null";
        }

        return "reference: " + message.toString();
    }
}
