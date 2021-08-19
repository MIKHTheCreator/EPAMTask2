package com.epam.jwd.application_runner;

import com.epam.jwd.complete_text.TextConstructor;
import com.epam.jwd.entity.SyntaxStructure;
import com.epam.jwd.entity.Text;

import static com.epam.jwd.reader.TxtFileReader.getFileText;

public class ApplicationRunner {

    public static void main(String[] args) {

        Text text = (Text) TextConstructor.getTextAsObject();
        System.out.println(text.getComponent());
//        System.out.println(TextConstructor.getText());
    }
}
