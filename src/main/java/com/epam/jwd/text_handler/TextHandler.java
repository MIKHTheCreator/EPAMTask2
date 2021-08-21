package com.epam.jwd.text_handler;

import com.epam.jwd.entity.Sentence;
import com.epam.jwd.entity.SyntaxStructure;
import com.epam.jwd.entity.Text;
import com.epam.jwd.entity.Word;
import com.epam.jwd.text_builder.TextConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class TextHandler {

    public static String getTextAsString() {
        return TextConstructor.buildText().getComponent();
    }

    public static void printText() {
        System.out.println(getTextAsString());
    }

    public static int findNumOfSentencesWithEqualsWords(Text text) {
        int numOfSentences = 0;
        for (SyntaxStructure sentence : text.getComponentList()) {
            if (isSentence(sentence)) {
                if (hasEqualWords(getSentenceWords((Sentence) sentence))) {
                    numOfSentences++;
                }
            }
        }

        return numOfSentences;
    }

    private static List<SyntaxStructure> getSentenceWords(Sentence sentence) {
        return sentence.getComponentList()
                .stream()
                .filter(structure -> structure instanceof Word)
                .collect(Collectors.toList());
    }

    private static boolean hasEqualWords(List<SyntaxStructure> sentenceWords) {

        return new HashSet<>(sentenceWords).size() < sentenceWords.size();
    }

    private static boolean isSentence(SyntaxStructure structure) {
        return structure instanceof Sentence;
    }

    public static void getSentencesByWordIncreasing(Text text) {
        List<SyntaxStructure> sentences = getSentences(text);

        sentences.sort((s1, s2) -> getSentenceWords((Sentence) s1).size() - getSentenceWords((Sentence) s2).size());
        sentences
                .forEach(sentence -> System.out.println("Sentence: " + sentence.getComponent()
                        .trim()
                        .replaceAll("\n", " ")));
    }

    private static List<SyntaxStructure> getSentences(Text text) {
        List<SyntaxStructure> sentences = new ArrayList<>();

        for (SyntaxStructure sentence : text.getComponentList()) {
            if (isSentence(sentence)) {
                sentences.add(sentence);
            }
        }
        return sentences;
    }

    public static String findExclusiveWord(Text text) {
        String exclusiveWord = "There is no exclusive words in first sentence!";
        List<SyntaxStructure> firstSentenceWords = getSentenceWords((Sentence) getSentences(text).get(0));

        text.removeComponent(0);
        String textAsString = text.getComponent();
        for (SyntaxStructure structure : firstSentenceWords) {

            String word = structure.getComponent();
            if (hasComponentInSyntaxStructure(textAsString, word)) {
                continue;
            }
            exclusiveWord = word;
        }

        return exclusiveWord;
    }

    private static boolean hasComponentInSyntaxStructure(String structure, String component) {
        return structure.contains(component);
    }
}
