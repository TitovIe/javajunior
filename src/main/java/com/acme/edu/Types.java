package com.acme.edu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public enum Types {
    CHAR, STRING, INTEGER, BYTE, BOOLEAN,
    REFERENCE, ARRAY_INT, ARRAY_STRING;

    public boolean isPrimitive() {
        Set<Types> setPrimitive =
                new HashSet<>(Arrays.asList(INTEGER, BYTE, BOOLEAN));

        return setPrimitive.contains(this);
    }

    public static boolean isEqual(Object object, Types that) {
        return Objects.equals(object.getClass().toString().toUpperCase(), that.toString());
    }
}
