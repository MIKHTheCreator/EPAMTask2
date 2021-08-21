package com.epam.jwd.reader;

import com.epam.jwd.exception.UnsupportedFileFormatException;
import com.epam.jwd.view.Menu;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import static com.epam.jwd.validation.FilePathValidation.isAvailableFilePath;

public class TxtFileReader {

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
//            Logging
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
                    System.exit(1);
                } else if (FIRST_TEST_FILE.equals(path)) {
                    path = "Test.txt";
                    break;
                } else if (SECOND_TEST_FILE.equals(path)) {
                    path = "Test2.txt";
                    break;
                } else if (isAvailableFilePath(path.trim())) {
                    break;
                }
            } catch (UnsupportedFileFormatException exception) {
//                Logging
                System.out.println(exception.getMessage());
                System.out.println(UNSUPPORTED_FILE_FORMAT_MESSAGE);
            } catch (FileNotFoundException exception) {
                System.out.println(exception.getMessage());
                System.out.println(FILE_NOT_FOUND_MESSAGE);
            }
        }

        return path;
    }

    private static void readTextFromFile(String filePath, StringBuilder buffer) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(filePath)))) {

            String fileText;
            while ((fileText = reader.readLine()) != null) {
                buffer.append(fileText).append("\n");
            }
        }
    }
}
