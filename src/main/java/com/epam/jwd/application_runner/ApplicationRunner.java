package com.epam.jwd.application_runner;

import com.epam.jwd.entity.Text;
import com.epam.jwd.parser.Parser;
import com.epam.jwd.parser.TextParser;
import com.epam.jwd.reader.TxtFileReader;
import com.epam.jwd.text_handler.TextHandler;


public class ApplicationRunner {

    public static void main(String[] args) {

        Text text = start();

        TextHandler.printText(text);
        System.out.println("=======================");
        System.out.println(TextHandler.findNumOfSentencesWithEqualsWords(text));
        System.out.println("=======================");
        TextHandler.getSentencesByWordIncreasing(text);
        System.out.println("=======================");
        System.out.println(TextHandler.findExclusiveWord(text));

    }

    public static Text start(){
        Parser parser = new TextParser();

        return new Text(parser.parse(TxtFileReader.getFileText()));
    }
}
