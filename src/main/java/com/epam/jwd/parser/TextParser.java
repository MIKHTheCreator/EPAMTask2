package com.epam.jwd.parser;

import com.epam.jwd.entity.impl.CodeBlock;
import com.epam.jwd.entity.impl.Sentence;
import com.epam.jwd.entity.api.SyntaxStructure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parse class for text parsing using regex
 * @author Mikhail Kharevich
 */
public class TextParser extends Parser {

    private static final Logger log = LogManager.getLogger(TextParser.class);
    private static final String SENTENCE_PATTERN = "\\s*[A-Z]+[\\w\\d()\\-%+=;:\\\"'\\s,/>’“”<]*[.?!]+[\\s]*";
    private static final String TEXT_PATTERN = "[^.!?]*[.!?]";
    private static final String TEXT_PARSER_LOG_MESSAGE = "Text has been parsed";
    private final List<SyntaxStructure> componentList;

    {
        componentList = new ArrayList<>();
    }

    /**
     * {@link Parser#parse(String)}
     * @param structure structure to parse
     * @return list of parsed components
     */
    @Override
    public List<SyntaxStructure> parse(String structure) {
        Pattern pattern = Pattern.compile(TEXT_PATTERN);
        Matcher matcher = pattern.matcher(structure);

        while (matcher.find()) {
            String parsedStructure = matcher.group();
            if (parsedStructure.matches(SENTENCE_PATTERN)) {
                Parser nextParser = this.setNextParser(new SentenceParser());
                Sentence sentence = new Sentence(nextParser.parse(parsedStructure));
                componentList.add(sentence);
            } else {
                Parser nextParser = this.setNextParser(new CodeBlockParser());
                CodeBlock codeBlock = new CodeBlock(nextParser.parse(parsedStructure));
                componentList.add(codeBlock);
            }
        }

        log.info(TEXT_PARSER_LOG_MESSAGE);
        return componentList;

    }
}
