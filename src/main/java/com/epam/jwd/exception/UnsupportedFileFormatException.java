package com.epam.jwd.exception;

public class UnsupportedFileFormatException extends Exception{

    public UnsupportedFileFormatException() {
    }

    public UnsupportedFileFormatException(String message) {
        super(message);
    }

    public UnsupportedFileFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedFileFormatException(Throwable cause) {
        super(cause);
    }
}
