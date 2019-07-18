package com.acme.edu;

import com.acme.edu.Decorator.*;
import com.acme.edu.Saver.LogSaverConsole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Logger {
    private static String primitive = "primitive";
    private static List<Object> buffer = new ArrayList<>();
    private static Accamulator accamulator = new Accamulator();
    private static String lastName = null;
    private static int counterString = 0;
    public static boolean isDecorated = true;

    public static void resetBuffer() {
        buffer.clear();
        isDecorated = true;
    }

    public static void flush() {
        if (buffer.isEmpty()) {
            return;
        }

        int sumPrimitive = 0;

        for (Object value : buffer) {
            sumPrimitive = sumAndCheckLimit(sumPrimitive, value);
        }

        buffer.clear();
        System.out.println(sumPrimitive);
    }

    private static int sumAndCheckLimit(int sumPrimitive, Object value) {
        if (value instanceof Integer) {
            int valueInt = (int) value;
            if ((valueInt >= 0 && Integer.MAX_VALUE - valueInt > sumPrimitive)
                    || (valueInt <= 0 && Byte.MAX_VALUE + valueInt < sumPrimitive)) {
                sumPrimitive += valueInt;
            } else {
                System.out.println(sumPrimitive);
                sumPrimitive = valueInt;
            }
        } else {
            byte valueByte = (byte) value;
            if ((valueByte >= 0 && Byte.MAX_VALUE - valueByte > sumPrimitive)
                    || (valueByte <= 0 && Byte.MAX_VALUE + valueByte < sumPrimitive)) {
                sumPrimitive += valueByte;
            } else {
                System.out.println(sumPrimitive);
                sumPrimitive = valueByte;
            }
        }
        return sumPrimitive;
    }

    private static void saveNotDecorated(String type, Object message) {
        if (Objects.equals(type, primitive) &&
                !(message instanceof Boolean)) {
            buffer.add(message);
            return;
        } else {
            flush();
        }

        System.out.println(String.valueOf(message));
    }

    private static void saveNotDecorated(Types type, Object message) {
        if (type.isPrimitive() &&
                !(message instanceof Boolean)) {
            buffer.add(message);
            return;
        } else {
            flush();
        }

        System.out.println(String.valueOf(message));
    }

    private static void saveLog(String type, Object message) {
        if (isDecorated) {
            if (message instanceof int[]) {
                String res = Arrays.toString((int[]) message)
                        .replace('[', '{')
                        .replace(']', '}');
                System.out.println(getType(type) + res);
            } else if (message instanceof String[]) {
                String res = String.join(System.lineSeparator(), (String[]) message);
                System.out.println(getType(type) + res);
            } else {
                System.out.println(getType(type) + String.valueOf(message));
            }
        } else {
            saveNotDecorated(type, message);
        }
    }

    private static void saveLog(Types type, Object message) {
        if (isDecorated) {
            if (message instanceof int[]) {
                String res = Arrays.toString((int[]) message)
                        .replace('[', '{')
                        .replace(']', '}');
                System.out.println(type + res);
            } else if (message instanceof String[]) {
                String res = String.join(System.lineSeparator(), (String[]) message);
                System.out.println(type + res);
            } else {
                System.out.println(type + String.valueOf(message));
            }
        } else {
            saveNotDecorated(type, message);
        }
    }

    private static String getType(String type) {
        return type + ": ";
    }

    public static void log(int message) throws Exception {
        //saveLog(primitive, message);

        Command command;
        if (isDecorated)
            command = new Command(new DecoratorPrimitive(), message);
        else
            command = new Command(accamulator, message);

        LoggerController loggerController =
                new LoggerController(new LogSaverConsole(), command);
        loggerController.getLogSaver().save(command);
    }

    public static void log(byte message) throws Exception {
        //saveLog(primitive, message);

        Command command = new Command(new DecoratorPrimitive(), message);
        LoggerController loggerController =
                new LoggerController(new LogSaverConsole(), command);
        loggerController.getLogSaver().save(command);
    }

    public static void log(char message) throws Exception {
        //saveLog("char", message);

        Command command = new Command(new DecoratorChar(), message);
        LoggerController loggerController =
                new LoggerController(new LogSaverConsole(), command);
        loggerController.getLogSaver().save(command);
    }

    public static void log(String message) throws Exception {
        //saveLog("string", message);

        Command command;
        if (isDecorated)
            command = new Command(new DecoratorString(), message);
        else
            command = new Command(accamulator, message);

        LoggerController loggerController =
                new LoggerController(new LogSaverConsole(), command);
        loggerController.getLogSaver().save(command);
    }

    public static void log(boolean message) throws Exception {
        //saveLog(primitive, message);

        Command command = new Command(new DecoratorPrimitive(), message);
        LoggerController loggerController =
                new LoggerController(new LogSaverConsole(), command);
        loggerController.getLogSaver().save(command);
    }

    public static void log(Object message) throws Exception {
//        if (message == null) {
//            message = "null";
//        }
//        saveLog("reference", message);

        Command command = new Command(new DecoratorObject(), message);
        LoggerController loggerController =
                new LoggerController(new LogSaverConsole(), command);
        loggerController.getLogSaver().save(command);
    }

    public static void log(int... arrayInt) throws Exception {
        //saveLog("primitives array", arrayInt);

        Command command = new Command(new DecoratorArrayInt(), arrayInt);
        LoggerController loggerController =
                new LoggerController(new LogSaverConsole(), command);
        loggerController.getLogSaver().save(command);
    }

    public static void log(String... arrayString) throws Exception {
        //saveLog("", arrayString);

        Command command = new Command(new DecoratorArrayString(), arrayString);
        LoggerController loggerController =
                new LoggerController(new LogSaverConsole(), command);
        loggerController.getLogSaver().save(command);
    }
}
