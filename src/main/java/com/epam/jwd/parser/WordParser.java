package com.epam.jwd.parser;

import com.epam.jwd.entity.SyntaxStructure;
import com.epam.jwd.entity.Word;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser {

    private static final String WORD_PATTERN = "[\\w\\d]+";

    public static SyntaxStructure parseSentence(String sentence){
        Pattern pattern = Pattern.compile(WORD_PATTERN);
        Matcher matcher = pattern.matcher(sentence);

        return matcher.find()
                ? new Word(matcher.group())
                : new Word("");
    }
}
