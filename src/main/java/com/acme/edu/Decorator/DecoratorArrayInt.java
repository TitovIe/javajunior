package com.acme.edu.Decorator;

import java.util.Arrays;

public class DecoratorArrayInt implements Decorator {
    @Override
    public String getDecorString(Object message) throws Exception {
        String messageDecor = Arrays.toString((int[]) message)
                .replace('[', '{')
                .replace(']', '}');

        return "primitives array: " + messageDecor;
    }
}
