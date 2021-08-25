package com.epam.jwd.parser;

import com.epam.jwd.entity.impl.PunctuationMark;
import com.epam.jwd.entity.api.SyntaxStructure;
import com.epam.jwd.entity.impl.Word;

import java.util.List;

/**
 * Common Parse class created for parsing text for different elements and creating text as a structure
 * @author Mikhail Kharevich
 */
public abstract class Parser {

    private Parser nextParser;

    /**
     * Method for getting next Parser object in chain
     * @return next Parser object
     */
    public Parser getNextParser() {
        return nextParser;
    }

    /**
     * Method for setting next Parser object in chain
     * @return next Parser object
     */
    public Parser setNextParser(Parser nextParser) {
        this.nextParser = nextParser;
        return nextParser;
    }

    /**
     * Method for parsing structure as different elements
     * @param structure structure to parse
     * @return list of parsed objects
     */
    public abstract List<SyntaxStructure> parse(String structure);

    protected SyntaxStructure getStructureByType(String parsedStructure, String pattern) {
        if (parsedStructure.matches(pattern)) {
            return new Word(parsedStructure);
        }

        return new PunctuationMark(parsedStructure);
    }

    @Override
    public String toString() {
        return "Parser{" +
                "nextParser=" + nextParser +
                '}';
    }
}
