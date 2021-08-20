package com.epam.jwd.parser;

import com.epam.jwd.entity.CodeBlock;
import com.epam.jwd.entity.Sentence;
import com.epam.jwd.entity.SyntaxStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser extends Parser{

    private static final String SENTENCE_PATTERN = "[A-Z]+[\\w\\d()\\-%+=;:\"'\s,/>’“”<]*[.?!:]+[\s]*";
    private static final String TEXT_PATTERN = "[^.!?]*[.!?]";
    private final List<SyntaxStructure> componentList;

    {
        componentList = new ArrayList<>();
    }

    public List<SyntaxStructure> getComponentList() {
        return componentList;
    }

    @Override
    public List<SyntaxStructure> parse(String structure) {
        Pattern pattern = Pattern.compile(TEXT_PATTERN);
        Matcher matcher = pattern.matcher(structure);

        while (matcher.find()){
            String parsedStructure = matcher.group();
            if(parsedStructure.matches(SENTENCE_PATTERN)){
                Parser nextParser = this.setNextParser(new SentenceParser());
                Sentence sentence = new Sentence(nextParser.parse(parsedStructure));
                componentList.add(sentence);
            } else {
                Parser nextParser = this.setNextParser(new CodeBlockParser());
                CodeBlock codeBlock = new CodeBlock(nextParser.parse(parsedStructure));
                componentList.add(codeBlock);
            }
        }

        return componentList;
    }
}
