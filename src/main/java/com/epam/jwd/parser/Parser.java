package com.epam.jwd.parser;

import com.epam.jwd.entity.PunctuationMark;
import com.epam.jwd.entity.SyntaxStructure;
import com.epam.jwd.entity.Word;

import java.util.List;

public abstract class Parser {

    private Parser nextParser;

    public Parser getNextParser() {
        return nextParser;
    }

    public Parser setNextParser(Parser nextParser) {
        this.nextParser = nextParser;
        return nextParser;
    }

    public abstract List<SyntaxStructure> parse(String structure);

    protected SyntaxStructure getStructureByType(String parsedStructure, String pattern){
        if(parsedStructure.matches(pattern)){
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
