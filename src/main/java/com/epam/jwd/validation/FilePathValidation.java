package com.epam.jwd.validation;

import com.epam.jwd.exception.UnsupportedFileFormatException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Class which keeps inside method for path validation
 * @author Mikhail Kharevich
 */
public class FilePathValidation {

    private static final Logger log = LogManager.getLogger(FilePathValidation.class);

    private static final String FILE_FORMAT_EXCEPTION_MESSAGE = "Selected file format must be .txt";
    private static final String FILE_NOT_FOUND_EXCEPTION_MESSAGE = "File with such name isn't found";
    private static final String FILE_PATH_PATTERN = "([A-Z]:)?[/\\\\].*\\.txt";
    private static final String PATH_IS_AVAILABLE_LOG_MESSAGE = "Path is available";

    /**
     * Method for getting information about valid or not user file path is
     * @param path users file path
     * @return true if input file path valid false otherwise
     * @throws UnsupportedFileFormatException {@link UnsupportedFileFormatException}
     * @throws FileNotFoundException when user's file wasn't find
     */
    public static boolean isAvailableFilePath(String path)
            throws UnsupportedFileFormatException, FileNotFoundException {

        if (new File(path).exists()) {
            if (path.matches(FILE_PATH_PATTERN)) {
                log.info(PATH_IS_AVAILABLE_LOG_MESSAGE);
                return true;
            } else {
                throw new UnsupportedFileFormatException(FILE_FORMAT_EXCEPTION_MESSAGE);
            }
        } else {
            throw new FileNotFoundException(FILE_NOT_FOUND_EXCEPTION_MESSAGE);
        }

    }
}
