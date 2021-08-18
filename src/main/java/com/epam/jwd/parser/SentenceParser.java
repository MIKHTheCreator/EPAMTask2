package com.epam.jwd.parser;

import com.epam.jwd.entity.SyntaxStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser {

    private static final String SENTENCE_PATTERN = "[A-Z]+" +
            "[\\w\\d\\(\\)\\-%\\+\\=;:\\\"\\'\\s,\\/\\>\\<\\=]*[\\.\\?\\!:]+\\s+";


    public static List<SyntaxStructure> parseText(String text){
        Pattern pattern = Pattern.compile(SENTENCE_PATTERN);
        Matcher matcher = pattern.matcher(text);
        List<SyntaxStructure> componentList = new ArrayList<>();

        String parsedSentence = "";

        while(matcher.find()){

        }
        return componentList;
    }
}
