package com.epam.jwd.exception;

/**
 * Exception class which keeps inside information about Wrong file format exception
 * @author Mikhail Kharevich
 */
public class UnsupportedFileFormatException extends Exception {

    /**
     * {@link Exception#Exception()}
     */
    public UnsupportedFileFormatException() {
    }

    /**
     * {@link Exception#Exception(String)}
     * @param message exception message
     */
    public UnsupportedFileFormatException(String message) {
        super(message);
    }

    /**
     * {@link Exception#Exception(String, Throwable)}
     * @param message exception message
     * @param cause cause exception
     */
    public UnsupportedFileFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * {@link Exception#Exception(Throwable)}
     * @param cause cause exception
     */
    public UnsupportedFileFormatException(Throwable cause) {
        super(cause);
    }
}
