package com.dnd.DND.Exceptions;

public class EmailExistsException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public EmailExistsException(String message) {
        super(message);
    }
    public EmailExistsException(String message,Throwable cause){
        super(message,cause);
    }
}
