package com.phyex0.cassandra.exception;

import java.io.Serial;

public class LibraryAlreadyExistsException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -2913338167705881854L;

    public LibraryAlreadyExistsException(String message) {
        super(message);
    }
}
