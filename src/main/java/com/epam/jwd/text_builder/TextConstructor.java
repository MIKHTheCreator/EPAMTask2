package com.epam.jwd.text_builder;

import com.epam.jwd.parser.Parser;
import com.epam.jwd.parser.TextParser;
import com.epam.jwd.entity.SyntaxStructure;
import com.epam.jwd.entity.Text;
import com.epam.jwd.reader.TxtFileReader;

public class TextConstructor {

    public static SyntaxStructure buildText(){
        Parser parser = new TextParser();

        return new Text(parser.parse(TxtFileReader.getFileText()));
    }
}
