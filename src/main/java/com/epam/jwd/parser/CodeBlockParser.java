package com.epam.jwd.parser;

import com.epam.jwd.entity.api.SyntaxStructure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Parser class which parse code block and creates word and punctuation mark objects using regex
 * @author Mikhail Kharevich
 */
public class CodeBlockParser extends Parser {

    private static final Logger log = LogManager.getLogger(SentenceParser.class);

    private static final String WORD_PATTERN = "[\\w\\d]+";
    private static final String CODE_BLOCK_SEPARATOR = "\\b";
    private static final String CODE_BLOCK_PARSER_LOG_MESSAGE = "CodeBlock has been parsed successfully";

    private final List<SyntaxStructure> codeBlockList;

    {
        codeBlockList = new ArrayList<>();
    }

    /**
     * {@link Parser#parse(String)}
     * @param structure structure to parse
     * @return list of parsed objects
     */
    @Override
    public List<SyntaxStructure> parse(String structure) {
        List<String> parsedStructure = Arrays
                .stream(structure.split(CODE_BLOCK_SEPARATOR))
                .collect(Collectors.toList());
        for (String element : parsedStructure) {
            codeBlockList.add(getStructureByType(element, WORD_PATTERN));
        }

        log.info(CODE_BLOCK_PARSER_LOG_MESSAGE);
        return codeBlockList;
    }
}
