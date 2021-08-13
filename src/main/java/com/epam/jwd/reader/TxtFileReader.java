package com.epam.jwd.reader;

import com.epam.jwd.exception.UnsupportedFileFormatException;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import static com.epam.jwd.validation.FilePathValidation.isTxtFilePath;

public class TxtFileReader {

    private static final String EXIT_COMMAND = "exit";

    public static String getFileText(){
        StringBuilder builder = new StringBuilder();

        try{
            readTextFromFile(getFilePath(), builder);
        }catch (IOException ex){
//            Logging
            System.out.println(ex.getMessage());
        }

        return builder.toString();
    }
    public static String getFilePath() {
        System.out.println("Enter file path(.txt files only supported): ");

        Scanner scan = new Scanner(System.in);
        String path = "";

        while(scan.hasNext()){
            path = scan.nextLine();
            try{
                if(path.trim().equalsIgnoreCase(EXIT_COMMAND)){
                    System.exit(1);
                } else if (isTxtFilePath(path.trim())) {
                    break;
                }
            }catch (UnsupportedFileFormatException exception){
//                Logging
                System.out.println(exception.getMessage());
                System.out.println("Try to write path again or enter exit to close the programme: ");
            }
        }

        return path;
    }

    private static void readTextFromFile(String filePath, StringBuilder buffer) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(filePath)))) {

            String fileText;
            while ((fileText = reader.readLine()) != null) {
                buffer.append(fileText).append("\n");
            }
        }
    }
}
