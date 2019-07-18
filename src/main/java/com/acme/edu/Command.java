package com.acme.edu;

import com.acme.edu.Decorator.Decorator;

public class Command {
    private Decorator decorator;
    private Accamulator accamulator;
    private Object message;
    private String messageDecor = "";

    public Command(Decorator decorator, Object message) throws Exception {
        this.decorator = decorator;
        this.message = message;
        messageDecor = this.decorator.getDecorString(this.message);
    }

    public Command(Accamulator accamulator, Object message) {
        this.accamulator = accamulator;
        this.message = message;
        sumPart(this.accamulator.saveData(this.message));
    }

    private void sumPart(String partMessage) {
        if (!partMessage.isEmpty())
            messageDecor += partMessage;
    }

    @Override
    public String toString() {
        try {
            return messageDecor;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
