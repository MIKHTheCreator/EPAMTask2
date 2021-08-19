package com.epam.jwd.parser;

import com.epam.jwd.entity.SyntaxStructure;

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

    @Override
    public String toString() {
        return "Parser{" +
                "nextParser=" + nextParser +
                '}';
    }
}
