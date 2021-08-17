package com.epam.jwd.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser {

    private static final String WORD_PATTERN = "[\\w\\d]+";

    public static String parseSentence(String sentence){
        Pattern pattern = Pattern.compile(WORD_PATTERN);
        Matcher matcher = pattern.matcher(sentence);

        return matcher.find() ? matcher.group() : "";
    }
}
