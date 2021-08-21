package com.epam.jwd.validation;

import com.epam.jwd.exception.UnsupportedFileFormatException;

import java.io.File;
import java.io.FileNotFoundException;

public class FilePathValidation {

    private static final String FILE_FORMAT_EXCEPTION_MESSAGE = "Selected file format must be .txt";
    private static final String FILE_NOT_FOUND_EXCEPTION_MESSAGE = "File with such name isn't found";
    private static final String FILE_PATH_PATTERN = "([A-Z]:)?[/\\\\].*\\.txt";

    public static boolean isTxtFilePath(String path)
            throws UnsupportedFileFormatException, FileNotFoundException {

        if(new File(path).exists()){
            if(path.matches(FILE_PATH_PATTERN)){
                return true;
            } else {
                throw new UnsupportedFileFormatException(FILE_FORMAT_EXCEPTION_MESSAGE);
            }
        } else {
            throw new FileNotFoundException(FILE_NOT_FOUND_EXCEPTION_MESSAGE);
        }

    }
}
