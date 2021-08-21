package com.epam.jwd.parser;

import com.epam.jwd.entity.SyntaxStructure;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SentenceParser extends Parser {

    private static final Logger log = Logger.getLogger(SentenceParser.class);

    private static final String WORD_PATTERN = "[\\w\\d]+";

    private final List<SyntaxStructure> sentenceList;

    {
        sentenceList = new ArrayList<>();
    }

    public List<SyntaxStructure> getSentenceList() {
        return sentenceList;
    }

    @Override
    public List<SyntaxStructure> parse(String structure) {
        List<String> parsedStructure = Arrays
                .stream(structure.split("\\b"))
                .collect(Collectors.toList());
        log.info("Sentence has bean splited");
        for (String element : parsedStructure) {
            sentenceList.add(getStructureByType(element, WORD_PATTERN));
        }

        log.info("Sentence has been parsed successfully");
        return sentenceList;
    }
}
