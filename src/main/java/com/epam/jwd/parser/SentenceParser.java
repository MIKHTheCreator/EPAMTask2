package com.epam.jwd.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser {

    private static final String SENTENCE_PATTERN = "[A-Z]+" +
            "[\\w\\d\\(\\)\\-%\\+\\=;:\\\"\\'\\s,\\/\\>\\<\\=]*[\\.\\?\\!:]+\\s+";

    public static String parseText(String text){
        Pattern pattern = Pattern.compile(SENTENCE_PATTERN);
        Matcher matcher = pattern.matcher(text);

        return matcher.find() ? matcher.group() : "";
    }
}
