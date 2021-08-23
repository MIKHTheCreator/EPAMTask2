package com.epam.jwd.text_handler;

import com.epam.jwd.entity.Sentence;
import com.epam.jwd.entity.SyntaxStructure;
import com.epam.jwd.entity.Text;
import com.epam.jwd.entity.Word;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import static com.epam.jwd.view.Menu.exit;

public class TextHandler {

    private static final Logger log = LogManager.getLogger(TextHandler.class);

    private static final String ILLEGAL_WORD_LENGTH_MESSAGE = "Word length must be greater then zero!";
    private static final String ENTER_WORD_LENGTH = "Enter word length(if input doesn't match a number will be used default length=4):";
    private static final int DEFAULT_WORD_LENGTH = 4;
    private static final String IMPOSSIBLE_TO_READ_TEXT = "You can't rollback the text";

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
                .filter(TextHandler::isWord)
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
        System.out.println(ENTER_WORD_LENGTH);

        int wordLength = scanner.hasNextInt()
                ? scanner.nextInt()
                : DEFAULT_WORD_LENGTH;

        if (wordLength <= 0) {
            System.out.println(ILLEGAL_WORD_LENGTH_MESSAGE);
        }

        for (SyntaxStructure sentence : getQuestionSentences(text)) {
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

    private static List<SyntaxStructure> getQuestionSentences(Text text) {
        return getSentences(text)
                .stream()
                .filter(sentence -> sentence
                        .getComponent()
                        .trim()
                        .endsWith("?"))
                .collect(Collectors.toList());
    }

    public static void swapFirstAndLastWords(Text text) {
        for (SyntaxStructure structure : text.getComponentList()) {
            if (isSentence(structure)) {
                List<SyntaxStructure> structures = ((Sentence) structure).getComponentList();
                int firstWordPosition = findFirstWordInSentence((Sentence) structure);

                SyntaxStructure word = structures.get(firstWordPosition);
                ((Sentence) structure)
                        .getComponentList()
                        .set(firstWordPosition, structures.get(structures.size() - 2));
                ((Sentence) structure)
                        .getComponentList()
                        .set(structures.size() - 2, word);
            }
        }
        log.info("Words have been swapped");
    }

    private static int findFirstWordInSentence(Sentence sentence) {
        int index = 0;

        for (SyntaxStructure structure : sentence.getComponentList()) {
            if (isWord(structure)) {
                return index;
            }

            index++;
        }

        return index;
    }

    private static boolean isWord(SyntaxStructure structure) {
        return structure instanceof Word;
    }

    public static Text rollback(Text text) {

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("TextState.bat"))) {

            text = (Text) inputStream.readObject();
        } catch (IOException ex) {
            log.error("IOException caught: " + ex);
            System.out.println(IMPOSSIBLE_TO_READ_TEXT);
        } catch (ClassNotFoundException ex) {
            log.error("ClassNotFoundException caught: " + ex);
            exit();
        }

        log.info("Rollback successful");
        return text;
    }

    public static void saveTextState(Text text) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("TextState.bat"))) {
            outputStream.writeObject(text);
        } catch (IOException ex) {
            log.error("IOException caught: " + ex);
        }
    }

    public static void printSentenceWordsInAlphabeticSort(Text text) {
        List<String> sortedWords = new ArrayList<>();

        for (SyntaxStructure sentence : getSentences(text)) {
            sortedWords.addAll(getSentenceWords((Sentence) sentence)
                    .stream()
                    .map(word -> word.getComponent()
                            .toLowerCase())
                    .collect(Collectors.toList()));
        }

        sortedWords = sortedWords
                .stream()
                .sorted()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(sortedWords.get(0));

        for (int i = 1; i < sortedWords.size(); i++) {
            String word = sortedWords.get(i);
            String previousWord = sortedWords.get(i - 1);
            if (word.charAt(0) != previousWord.charAt(0)) {
                System.out.print("\n\t" + word + ";");
            } else {
                System.out.print("\s" + word + ";");
            }
        }
        System.out.println("\n");
    }
}
