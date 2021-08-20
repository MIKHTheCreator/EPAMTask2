package com.epam.jwd.application_runner;

import com.epam.jwd.text_builder.TextConstructor;
import com.epam.jwd.entity.Text;
import com.epam.jwd.text_handler.TextHandler;


public class ApplicationRunner {

    public static void main(String[] args) {

        Text text = (Text) TextConstructor.buildText();
//        TextHandler.printText();
        System.out.println(TextHandler.findNumOfSentencesWithEqualsWords(text));


    }
}
