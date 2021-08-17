package com.epam.jwd.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeBlockParser{

    private static final String CODE_BLOCK_PATTERN = "";

    public static String parseTextForCodeBlock(String text){
        Pattern pattern = Pattern.compile(CODE_BLOCK_PATTERN);
        Matcher matcher = pattern.matcher(text);

        return matcher.find() ? matcher.group() : "";
    }

}
