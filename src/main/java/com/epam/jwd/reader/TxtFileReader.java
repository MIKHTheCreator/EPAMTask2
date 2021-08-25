package com.epam.jwd.reader;

import com.epam.jwd.exception.UnsupportedFileFormatException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import static com.epam.jwd.validation.FilePathValidation.isAvailableFilePath;
import static com.epam.jwd.view.Menu.exit;
import static com.epam.jwd.view.Menu.printStartMessage;

/**
 * Class which has method to read text from .txt file
 * @author Mikhail Kharevich
 */
public class TxtFileReader {

    private static final Logger log = LogManager.getLogger(TxtFileReader.class);

    private static final String EXIT_COMMAND = "exit";
    private static final String FIRST_TEST_FILE = "Test.txt";
    private static final String SECOND_TEST_FILE = "Test2.txt";
    private static final String START_MESSAGE = "Enter file path(.txt files only supported): ";
    private static final String UNSUPPORTED_FILE_FORMAT_MESSAGE = "Choose .txt file or enter exit to close the programme: ";
    private static final String FILE_NOT_FOUND_MESSAGE = "Write path again or enter exit to close the programme: ";
    private static final String IOEXCEPTION_LOG_MESSAGE = "IOException has been caught:  ";
    private static final String UNSUPPORTED_FILE_FORMAT_LOG_MESSAGE = "UnsupportedFileFormatException has been caught: ";
    private static final String FILE_NOT_FOUND_LOG_MESSAGE = "FileNotFound has been caught: ";
    private static final String FIRST_FILE_LOG_MESSAGE = "Test.txt file has been chosen";
    private static final String SECOND_FILE_LOG_MESSAGE = "Test2.txt file has been chosen";
    private static final String USER_FILE_LOG_MESSAGE = "User's file has been chosen: ";
    private static final String READ_TEXT_FILE_LOG_MESSAGE = "TextFile has been read";

    /**
     * Method for getting text from file as a string object
     * @return text as a string
     */
    public static String getFileText() {

        printStartMessage();
        StringBuilder builder = new StringBuilder();

        try {
            readTextFromFile(getFilePath(), builder);
        } catch (IOException ex) {
            log.error(IOEXCEPTION_LOG_MESSAGE, ex);
            System.out.println(ex.getMessage());
        }

        return builder.toString();
    }

    /**
     * Method which provides user with opportunity to choose his .txt file to read
     * @return users file path or default file paths if user choose them
     */
    public static String getFilePath() {
        System.out.println(START_MESSAGE);

        Scanner scan = new Scanner(System.in);
        String path = "";

        while (scan.hasNext()) {
            path = scan.nextLine();
            try {
                if (path.trim().equalsIgnoreCase(EXIT_COMMAND)) {
                    exit();
                } else if ("1".equals(path)) {
                    path = FIRST_TEST_FILE;
                    log.info(FIRST_FILE_LOG_MESSAGE);
                    break;
                } else if ("2".equals(path)) {
                    path = SECOND_TEST_FILE;
                    log.info(SECOND_FILE_LOG_MESSAGE);
                    break;
                } else if (isAvailableFilePath(path.trim())) {
                    log.info(USER_FILE_LOG_MESSAGE + path);
                    break;
                }
            } catch (UnsupportedFileFormatException ex) {
                log.error(UNSUPPORTED_FILE_FORMAT_LOG_MESSAGE, ex);
                System.out.println(ex.getMessage());
                System.out.println(UNSUPPORTED_FILE_FORMAT_MESSAGE);
            } catch (FileNotFoundException ex) {
                log.error(FILE_NOT_FOUND_LOG_MESSAGE,  ex);
                System.out.println(ex.getMessage());
                System.out.println(FILE_NOT_FOUND_MESSAGE);
            }
        }

        return path;
    }

    /**
     * Method for reading text from file using IOSteams
     * @param filePath path to file to read
     * @param builder StringBuilder object for saving text
     * @throws IOException exception provided when filePath isn't valid
     */
    private static void readTextFromFile(String filePath, StringBuilder builder) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(filePath)))) {

            String fileText;
            while ((fileText = reader.readLine()) != null) {
                builder.append(fileText).append("\n");
            }
        }

        log.info(READ_TEXT_FILE_LOG_MESSAGE);
    }
}
