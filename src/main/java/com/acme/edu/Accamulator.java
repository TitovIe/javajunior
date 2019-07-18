package com.acme.edu;

import java.util.ArrayList;
import java.util.List;

class Accamulator {
    private List<Object> buffer;
    private String messageDecor = "";

    Accamulator() {
        buffer = new ArrayList<>();
    }

    String saveData(Object message) {
        if (!(message instanceof String)) {
            buffer.add(message);
            return "";
        } else {
            messageDecor += flush();
        }

        return messageDecor;
    }

    private String flush() {
        if (buffer.isEmpty()) {
            return "";
        }

        int sumPrimitive = 0;
        for (Object value : buffer) {
            sumPrimitive = sumAndCheckLimit(sumPrimitive, value);
        }

        buffer.clear();
        return String.valueOf(sumPrimitive) + System.lineSeparator();
    }

    private int sumAndCheckLimit(int sumPrimitive, Object value) {
        if (value instanceof Integer) {
            int valueInt = (int) value;
            if ((valueInt >= 0 && Integer.MAX_VALUE - valueInt > sumPrimitive)
                    || (valueInt <= 0 && Byte.MAX_VALUE + valueInt < sumPrimitive)) {
                sumPrimitive += valueInt;
            } else {
                messageDecor += String.valueOf(sumPrimitive) + System.lineSeparator();
                ;
                sumPrimitive = valueInt;
            }
        } else {
            byte valueByte = (byte) value;
            if ((valueByte >= 0 && Byte.MAX_VALUE - valueByte > sumPrimitive)
                    || (valueByte <= 0 && Byte.MAX_VALUE + valueByte < sumPrimitive)) {
                sumPrimitive += valueByte;
            } else {
                messageDecor += String.valueOf(sumPrimitive) + System.lineSeparator();
                sumPrimitive = valueByte;
            }
        }
        return sumPrimitive;
    }
}
