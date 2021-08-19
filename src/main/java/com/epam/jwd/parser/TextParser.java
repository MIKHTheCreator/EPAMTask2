package com.epam.jwd.parser;

import com.epam.jwd.entity.CodeBlock;
import com.epam.jwd.entity.PunctuationMark;
import com.epam.jwd.entity.Sentence;
import com.epam.jwd.entity.SyntaxStructure;
import com.epam.jwd.entity.Text;
import com.epam.jwd.entity.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {

    private static final String SENTENCE_PATTERN = "[A-Z]+" +
            "[\\w\\d\\(\\)\\-%\\+\\=;:\\\"\\'\\s,\\/\\>\\<\\=]*[\\.\\?\\!:]+\\s+";
    private static final String CODE_BLOCK_PATTERN = "";
    //CODE_BLOCK+SENTENCE_PATTERN
    private static final String TEXT_PATTERN = "[" + SENTENCE_PATTERN + CODE_BLOCK_PATTERN + "]";
    private static final String PUNCTUATION_MARK_PATTERN = "[\\.,:;\\-+=!?\\{\\}\\(\\)\\[\\]\\/\\'\\\"\\>\\<\\%\s]";


    public static SyntaxStructure getTextObject(String text){
        Pattern pattern = Pattern.compile(TEXT_PATTERN);
        Matcher matcher = pattern.matcher(TEXT_PATTERN);
        List<SyntaxStructure> syntaxStructureList = new ArrayList<>();

        while(matcher.find()){
            String textStructure = matcher.group();

            if(textStructure.matches(SENTENCE_PATTERN)){
                String[] structureAsList = textStructure.split("\\b");
                List<SyntaxStructure> sentence = new ArrayList<>();

                for(String part : structureAsList){
                    if(part.matches("PUNCTUATION_MARK_PATTERN")){
                        sentence.add(new PunctuationMark(part));
                    } else {
                        sentence.add(new Word(part));
                    }
                }

                syntaxStructureList.add(new Sentence(sentence));
            } else {
                String[] structureAsList = textStructure.split("\\b");
                List<SyntaxStructure> codeBlock = new ArrayList<>();

                for(String part : structureAsList){
                    if(part.matches(PUNCTUATION_MARK_PATTERN)){
                        codeBlock.add(new PunctuationMark(part));
                    } else {
                        codeBlock.add(new Word(part));
                    }
                }

                syntaxStructureList.add(new CodeBlock(codeBlock));
            }
        }

        return new Text(syntaxStructureList);
    }
}
