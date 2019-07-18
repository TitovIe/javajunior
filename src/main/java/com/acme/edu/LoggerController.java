package com.acme.edu;

import com.acme.edu.Saver.LogSaver;

class LoggerController {
    private LogSaver logSaver;

    LoggerController(LogSaver logSaver, Command command) {
        this.logSaver = logSaver;
    }

    LogSaver getLogSaver() {
        return logSaver;
    }
}
