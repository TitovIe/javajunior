package com.acme.edu.Decorator;

public class DecoratorChar implements Decorator {
    @Override
    public String getDecorString(Object message) throws Exception {
        return "char: " + message.toString();
    }
}
