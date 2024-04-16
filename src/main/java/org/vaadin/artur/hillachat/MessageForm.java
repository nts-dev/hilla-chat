package org.vaadin.artur.hillachat;

import dev.hilla.Nonnull;

public class MessageForm {

    @Nonnull
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
