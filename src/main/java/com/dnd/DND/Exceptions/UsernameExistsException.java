package com.dnd.DND.Exceptions;

public class UsernameExistsException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public UsernameExistsException(String message) {
        super(message);
    }
    public UsernameExistsException(String message, Throwable cause){
        super(message,cause);
    }
}
