package com.epam.jwd.reader;

import com.epam.jwd.exception.UnsupportedFileFormatException;
import com.epam.jwd.view.Menu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import static com.epam.jwd.validation.FilePathValidation.isAvailableFilePath;

public class TxtFileReader {

    private static final Logger log = LogManager.getLogger(TxtFileReader.class);

    private static final String EXIT_COMMAND = "exit";
    private static final String FIRST_TEST_FILE = "1";
    private static final String SECOND_TEST_FILE = "2";
    private static final String START_MESSAGE = "Enter file path(.txt files only supported): ";
    private static final String UNSUPPORTED_FILE_FORMAT_MESSAGE = "Choose .txt file or enter exit to close the programme: ";
    private static final String FILE_NOT_FOUND_MESSAGE = "Write path again or enter exit to close the programme: ";

    public static String getFileText() {

        Menu.printStartMessage();
        StringBuilder builder = new StringBuilder();

        try {
            readTextFromFile(getFilePath(), builder);
        } catch (IOException ex) {
            log.error("IOException has been caught:" + ex.getMessage());
            System.out.println(ex.getMessage());
        }

        return builder.toString();
    }

    public static String getFilePath() {
        System.out.println(START_MESSAGE);

        Scanner scan = new Scanner(System.in);
        String path = "";

        while (scan.hasNext()) {
            path = scan.nextLine();
            try {
                if (path.trim().equalsIgnoreCase(EXIT_COMMAND)) {
                    Menu.exit();
                } else if (FIRST_TEST_FILE.equals(path)) {
                    path = "Test.txt";
                    log.info("Test.txt file has been chosen");
                    break;
                } else if (SECOND_TEST_FILE.equals(path)) {
                    path = "Test2.txt";
                    log.info("Test2.txt file has been chosen");
                    break;
                } else if (isAvailableFilePath(path.trim())) {
                    log.info("User's file has been chosen: " + path);
                    break;
                }
            } catch (UnsupportedFileFormatException ex) {
                log.error("UnsupportedFileFormatException has been caught: " + ex);
                System.out.println(ex.getMessage());
                System.out.println(UNSUPPORTED_FILE_FORMAT_MESSAGE);
            } catch (FileNotFoundException ex) {
                log.error("FileNotFound has been caught: " + ex);
                System.out.println(ex.getMessage());
                System.out.println(FILE_NOT_FOUND_MESSAGE);
            }
        }

        return path;
    }

    private static void readTextFromFile(String filePath, StringBuilder builder) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(filePath)))) {

            String fileText;
            while ((fileText = reader.readLine()) != null) {
                builder.append(fileText).append("\n");
            }
        }

        log.info("TextFile has been read");
    }
}
