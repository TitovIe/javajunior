package com.acme.edu.Saver;

import com.acme.edu.Command;

public interface LogSaver {
    Object save(Command command) throws Exception;
}
