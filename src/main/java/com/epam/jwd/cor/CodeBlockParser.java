package com.epam.jwd.cor;

import com.epam.jwd.entity.PunctuationMark;
import com.epam.jwd.entity.SyntaxStructure;
import com.epam.jwd.entity.Word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CodeBlockParser extends Parser {
    private static final String WORD_PATTERN = "[\\w\\d]+";
    //    private static final String PUNCTUATION_MARK_PATTERN = "[\\.,:;\\-+=!?\\{\\}\\(\\)\\[\\]\\/\\'\\\"\\>\\<\\%]";
    private final List<SyntaxStructure> codeBlockList;

    {
        codeBlockList = new ArrayList<>();
    }

    public List<SyntaxStructure> getSentenceList() {
        return codeBlockList;
    }

    @Override
    public List<SyntaxStructure> parse(String structure) {
        List<String> parsedStructure = Arrays
                .stream(structure.split("\\b"))
                .filter(string -> !string.equals(" "))
                .collect(Collectors.toList());
        for(String element : parsedStructure){
            codeBlockList.add(getStructureByType(element));
        }

        return codeBlockList;
    }

    private SyntaxStructure getStructureByType(String parsedStructure){
        if(parsedStructure.matches(WORD_PATTERN)){
            return new Word(parsedStructure);
        }

        return new PunctuationMark(parsedStructure);
    }
}
