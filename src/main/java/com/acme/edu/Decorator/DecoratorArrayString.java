package com.acme.edu.Decorator;

public class DecoratorArrayString implements Decorator {
    @Override
    public String getDecorString(Object message) throws Exception {
        String messageDecor = String.join(System.lineSeparator(), (String[]) message);
        return ": " + messageDecor;
    }
}
