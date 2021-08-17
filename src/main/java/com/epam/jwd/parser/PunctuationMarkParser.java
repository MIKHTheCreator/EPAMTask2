package com.epam.jwd.parser;

import com.epam.jwd.entity.PunctuationMark;
import com.epam.jwd.entity.SyntaxStructure;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PunctuationMarkParser {

    private static final String PUNCTUATION_MARK_PATTERN = "[\\.,:;\\-+=!?\\{\\}\\(\\)\\[\\]\\/\\'\\\"\\>\\<\\%]";

    public static SyntaxStructure parseSentenceForPunctuationMark(String sentence){
        Pattern pattern = Pattern.compile(PUNCTUATION_MARK_PATTERN);
        Matcher matcher = pattern.matcher(sentence);

        return matcher.find()
                ? new PunctuationMark(matcher.group())
                : new PunctuationMark("");
    }
}
