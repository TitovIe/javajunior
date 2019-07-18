package com.acme.edu.Decorator;

public class DecoratorPrimitive implements Decorator {
    @Override
    public String getDecorString(Object message) throws Exception {
        return "primitive: " + message.toString();
    }
}
