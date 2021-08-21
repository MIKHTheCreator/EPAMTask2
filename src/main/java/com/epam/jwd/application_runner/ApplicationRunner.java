package com.epam.jwd.application_runner;

import com.epam.jwd.entity.Text;
import com.epam.jwd.parser.Parser;
import com.epam.jwd.parser.TextParser;
import com.epam.jwd.reader.TxtFileReader;
import com.epam.jwd.text_handler.TextHandler;
import com.epam.jwd.view.Menu;


public class ApplicationRunner {

    public static void main(String[] args) {

        Text text = readFileToTextObject();
        Menu.getStartMenu();

    }

    public static Text readFileToTextObject(){
        Parser parser = new TextParser();

        return new Text(parser.parse(TxtFileReader.getFileText()));
    }
}
