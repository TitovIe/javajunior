package com.acme.edu.Saver;

import com.acme.edu.Command;

public class LogSaverConsole implements LogSaver {
    @Override
    public Object save(Command command) throws Exception {
        System.out.println(command);

        return null;
    }
}
