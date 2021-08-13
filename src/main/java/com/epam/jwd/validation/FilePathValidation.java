package com.epam.jwd.validation;

import com.epam.jwd.exception.UnsupportedFileFormatException;

import java.io.File;

public class FilePathValidation {

    private static final String FILE_FORMAT_EXCEPTION_MESSAGE = "Selected file format must be .txt";
    private static final String FILE_PATH_PATTERN = "([A-Z]:)?[\\/\\\\].*\\.txt";

    public static boolean isTxtFilePath(String path) throws UnsupportedFileFormatException {
        if(path.matches(FILE_PATH_PATTERN) && new File(path).exists()){
            return true;
        } else {
            throw new UnsupportedFileFormatException(FILE_FORMAT_EXCEPTION_MESSAGE);
        }
    }
}
