package com.epam.jwd.complete_text;

import com.epam.jwd.cor.Parser;
import com.epam.jwd.cor.TextParser;
import com.epam.jwd.entity.SyntaxStructure;
import com.epam.jwd.entity.Text;
import com.epam.jwd.reader.TxtFileReader;

public class TextConstructor {

    private static SyntaxStructure getTextAsObject(){
        Parser parser = new TextParser();

        return new Text(parser.parse(TxtFileReader.getFileText()));
    }

    public static String getText(){
        return getTextAsObject().getComponent();
    }
}
