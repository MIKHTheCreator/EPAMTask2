package com.epam.jwd.parser;

import com.epam.jwd.entity.SyntaxStructure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SentenceParser extends Parser {

    private static final Logger log = LogManager.getLogger(SentenceParser.class);

    private static final String WORD_PATTERN = "[\\w\\d]+";
    private static final String SENTENCE_SEPARATOR = "\\b";
    private static final String SENTENCE_PARSER_LOG_MESSAGE = "Sentence has been parsed successfully";

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
                .stream(structure.split(SENTENCE_SEPARATOR))
                .collect(Collectors.toList());
        for (String element : parsedStructure) {
            sentenceList.add(getStructureByType(element, WORD_PATTERN));
        }

        log.info(SENTENCE_PARSER_LOG_MESSAGE);
        return sentenceList;
    }
}
