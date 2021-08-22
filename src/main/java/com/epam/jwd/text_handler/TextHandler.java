package com.epam.jwd.text_handler;

import com.epam.jwd.entity.Sentence;
import com.epam.jwd.entity.SyntaxStructure;
import com.epam.jwd.entity.Text;
import com.epam.jwd.entity.Word;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class TextHandler {

    private static final Logger log = LogManager.getLogger(TextHandler.class);

    private static final String ILLEGAL_WORD_LENGTH_MESSAGE = "Word length must be greater then zero!";
    private static final String ENTER_WORD_LENGTH_MESSAGE = "Enter positive word length:";

    public static void printText(Text text) {
        log.info("Printing text...");
        System.out.println(text.getComponent());
    }

    public static int findNumOfSentencesWithEqualsWords(Text text) {
        int numOfSentences = 0;
        for (SyntaxStructure sentence : text.getComponentList()) {
            if (isSentence(sentence)) {
                if (hasEqualWords(getSentenceWords((Sentence) sentence))) {
                    numOfSentences++;
                    log.info("Sentence with equal word has been found. Num of such sentences: " + numOfSentences);
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

    public static void printSentencesByWordIncreasing(Text text) {
        List<SyntaxStructure> sentences = getSentences(text);

        log.info("Printing sentences by word amount increasing");
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

        log.info("Removing first sentence");
        text.removeComponent(0);
        String textAsString = text.getComponent();
        for (SyntaxStructure structure : firstSentenceWords) {

            String word = structure.getComponent();
            if (hasComponentInSyntaxStructure(textAsString, word)) {
                continue;
            }
            exclusiveWord = word;
            log.info("Exclusive word has been found: " + exclusiveWord);
        }

        return exclusiveWord;
    }

    private static boolean hasComponentInSyntaxStructure(String structure, String component) {
        return structure.contains(component);
    }

    public static List<SyntaxStructure> getWordsByLength(Text text) {
        List<SyntaxStructure> words = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println(ENTER_WORD_LENGTH_MESSAGE);

        int wordLength = scanner.nextInt();
        if (wordLength <= 0) {
            System.out.println(ILLEGAL_WORD_LENGTH_MESSAGE);
        }

        for (SyntaxStructure sentence : getQuestionSentences(text)){
            words.addAll(getSentenceWords((Sentence) sentence)
                    .stream()
                    .filter(word -> word.getComponent()
                            .toLowerCase(Locale.ROOT)
                            .length() == wordLength)
                    .collect(Collectors.toList()));
        }

        return words.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    private static List<SyntaxStructure> getQuestionSentences(Text text){
        return getSentences(text)
                .stream()
                .filter(sentence -> sentence.getComponent().trim().endsWith("?"))
                .collect(Collectors.toList());
    }
}
