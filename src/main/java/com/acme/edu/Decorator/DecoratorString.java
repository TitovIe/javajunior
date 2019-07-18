package com.acme.edu.Decorator;

public class DecoratorString implements Decorator {
    @Override
    public String getDecorString(Object message) throws Exception {
        return "string: " + message.toString();
    }
}
