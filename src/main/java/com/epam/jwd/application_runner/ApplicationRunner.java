package com.epam.jwd.application_runner;

import com.epam.jwd.entity.Text;
import com.epam.jwd.parser.Parser;
import com.epam.jwd.parser.TextParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.epam.jwd.reader.TxtFileReader.getFileText;
import static com.epam.jwd.text_handler.TextHandler.saveTextState;
import static com.epam.jwd.view.Menu.runMenu;

public class ApplicationRunner {

    private static final Logger log = LogManager.getLogger(ApplicationRunner.class);

    private static final String START_LOG_MESSAGE = "Application starts";

    public static void main(String[] args) {

        log.info(START_LOG_MESSAGE);
        Text text = readFileToTextObject();
        saveTextState(text);
        runMenu(text);

    }

    public static Text readFileToTextObject(){
        Parser parser = new TextParser();

        return new Text(parser.parse(getFileText()));
    }
}
