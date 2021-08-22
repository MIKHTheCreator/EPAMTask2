package com.epam.jwd.application_runner;

import com.epam.jwd.entity.Text;
import com.epam.jwd.parser.Parser;
import com.epam.jwd.parser.TextParser;

import static com.epam.jwd.reader.TxtFileReader.getFileText;
import static com.epam.jwd.text_handler.TextHandler.saveTextState;
import static com.epam.jwd.view.Menu.runMenu;

public class ApplicationRunner {

    public static void main(String[] args) {

        Text text = readFileToTextObject();
        saveTextState(text);
        runMenu(text);

    }

    public static Text readFileToTextObject(){
        Parser parser = new TextParser();

        return new Text(parser.parse(getFileText()));
    }
}
