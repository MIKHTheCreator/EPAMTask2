package com.epam.jwd.parser;

import com.epam.jwd.entity.PunctuationMark;
import com.epam.jwd.entity.SyntaxStructure;
import com.epam.jwd.entity.Word;
import org.apache.log4j.Logger;

import java.util.List;

public abstract class Parser {

    private static final Logger log = Logger.getLogger(Parser.class);

    private Parser nextParser;

    public Parser getNextParser() {
        return nextParser;
    }

    public Parser setNextParser(Parser nextParser) {
        log.info("Next parser " + nextParser+ "has been set");
        this.nextParser = nextParser;
        return nextParser;
    }

    public abstract List<SyntaxStructure> parse(String structure);

    protected SyntaxStructure getStructureByType(String parsedStructure, String pattern) {
        if (parsedStructure.matches(pattern)) {
            log.info("Getting Word object" );
            return new Word(parsedStructure);
        }

        log.info("Getting Punctuation Mark Object");
        return new PunctuationMark(parsedStructure);
    }

    @Override
    public String toString() {
        return "Parser{" +
                "nextParser=" + nextParser +
                '}';
    }
}
