package com.epam.jwd.text_handler;

import com.epam.jwd.entity.impl.Sentence;
import com.epam.jwd.entity.api.SyntaxStructure;
import com.epam.jwd.entity.impl.Text;
import com.epam.jwd.entity.impl.Word;
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

/**
 * Class which provides user with different text operations
 * @author Mikhail Kharevich
 */
public class TextHandler {

    private static final Logger log = LogManager.getLogger(TextHandler.class);

    private static final String OBJECT_STATE_FILE = "TextState.bat";
    private static final String WORDS_DELIMITER = ";";
    private static final String ILLEGAL_WORD_LENGTH_MESSAGE = "Word length must be greater then zero!";
    private static final String ENTER_WORD_LENGTH = "Enter word length(if input doesn't match a number will be used default length=4):";
    private static final String IMPOSSIBLE_TO_READ_TEXT = "You can't rollback the text";
    private static final String PRINT_TEXT_LOG_MESSAGE = "Printing text...";
    private static final String SENTENCES_WITH_EQUAL_WORDS_LOG_MESSAGE = "Sentence with equal word has been found. Num of such sentences: ";
    private static final String SENTENCES_BY_WORD_AMOUNT_LOG_MESSAGE = "Printing sentences by word amount increasing";
    private static final String EXCLUSIVE_WORD_LOG_MESSAGE = "Exclusive word has been found: ";
    private static final String WORD_SWAPPER_LOG_MESSAGE = "Words have been swapped";
    private static final String ROLLBACK_LOG_MESSAGE = "Rollback successful";
    private static final String IOEXCEPTION_LOG_MESSAGE = "IOException caught: ";
    private static final String CLASS_NOT_FOUND_LOG_MESSAGE = "ClassNotFoundException caught: ";
    private static final int DEFAULT_WORD_LENGTH = 4;

    /**
     * Method for printing Text object as a string in console
     * @param text text object to print
     */
    public static void printText(Text text) {
        log.info(PRINT_TEXT_LOG_MESSAGE);
        System.out.println(text.getComponent());
    }

    /**
     * Method for finding number of sentences with equal words
     * @param text text object to work with
     * @return number of sentences with equal words
     */
    public static int findNumOfSentencesWithEqualsWords(Text text) {
        int numOfSentences = 0;
        for (SyntaxStructure sentence : text.getComponentList()) {
            if (isSentence(sentence)) {
                if (hasEqualWords(getSentenceWords((Sentence) sentence))) {
                    numOfSentences++;
                    log.info(SENTENCES_WITH_EQUAL_WORDS_LOG_MESSAGE + numOfSentences);
                }
            }
        }

        return numOfSentences;
    }

    /**
     * Method for getting list of SyntaxStructure objects, which contains only Words
     * @param sentence Sentence object
     * @return list of word components
     */
    private static List<SyntaxStructure> getSentenceWords(Sentence sentence) {
        return sentence.getComponentList()
                .stream()
                .filter(TextHandler::isWord)
                .collect(Collectors.toList());
    }

    /**
     * Method for checking if there is equal words in one sentence
     * @param sentenceWords sentence words
     * @return true if there is equal words in one sentence, false otherwise
     */
    private static boolean hasEqualWords(List<SyntaxStructure> sentenceWords) {

        return new HashSet<>(sentenceWords).size() < sentenceWords.size();
    }

    /**
     * Method for getting information about is current SyntaxStructure sentence or not
     * @param structure SyntaxStructure
     * @return true if SyntaxStructure is sentence, false otherwise
     */
    private static boolean isSentence(SyntaxStructure structure) {

        return structure instanceof Sentence;
    }

    /**
     * Method for printing sentences by words increasing,
     * print sentences in word amount sort
     * @param text text object to work with
     */
    public static void printSentencesByWordIncreasing(Text text) {
        List<SyntaxStructure> sentences = getSentences(text);

        log.info(SENTENCES_BY_WORD_AMOUNT_LOG_MESSAGE);
        sentences.sort((s1, s2) -> getSentenceWords((Sentence) s1).size() - getSentenceWords((Sentence) s2).size());
        sentences.forEach(sentence -> System.out.println("Sentence: " + sentence.getComponent()
                        .trim()
                        .replaceAll("\n", " ")));
    }

    /**
     * Method for getting sentences from text object
     * @param text text object to work with
     * @return list of sentences a list of SyntaxStructure objects
     */
    private static List<SyntaxStructure> getSentences(Text text) {
        List<SyntaxStructure> sentences = new ArrayList<>();

        for (SyntaxStructure sentence : text.getComponentList()) {
            if (isSentence(sentence)) {
                sentences.add(sentence);
            }
        }
        return sentences;
    }

    /**
     * Method for getting exclusive word in first sentence, which never used in next sentences
     * @param text text object to work with
     * @return exclusive word as a string
     */
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
            log.info(EXCLUSIVE_WORD_LOG_MESSAGE + exclusiveWord);
        }

        return exclusiveWord;
    }

    /**
     * Method for checking is the component in SyntaxStructure
     * @param structure SyntaxStructure object, where method find the component
     * @param component component to find
     * @return true, if method find component in structure, false otherwise
     */
    private static boolean hasComponentInSyntaxStructure(String structure, String component) {
        return structure.contains(component);
    }

    /**
     * Method for getting words by length
     * @param text text object to work with
     * @return list of Words of concrete length or if length isn't valid then words of default length
     */
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

    /**
     * Method for getting question sentences from text
     * @param text text object to work with
     * @return list of question sentences
     */
    private static List<SyntaxStructure> getQuestionSentences(Text text) {
        return getSentences(text)
                .stream()
                .filter(sentence -> sentence
                        .getComponent()
                        .trim()
                        .endsWith("?"))
                .collect(Collectors.toList());
    }

    /**
     * Method for swapping first and last words in sentence
     * @param text text object to work with
     */
    public static void swapFirstAndLastWords(Text text) {
        for (SyntaxStructure structure : text.getComponentList()) {
            if (isSentence(structure)) {
                Sentence sentence = (Sentence) structure;
                List<SyntaxStructure> structures = sentence.getComponentList();
                int firstWordPosition = findFirstWordInSentence((Sentence) structure);

                SyntaxStructure word = structures.get(firstWordPosition);
                int lastWordPosition = structures.size() - 2;

                setSentenceElement(sentence, firstWordPosition, structures.get(lastWordPosition));
                setSentenceElement(sentence, lastWordPosition, word);
            }
        }
        log.info(WORD_SWAPPER_LOG_MESSAGE);
    }

    /**
     * Method for setting sentence element on concrete position
     * @param sentence sentence for setting element
     * @param position position of concrete element
     * @param element element to set on the position
     */
    private static void setSentenceElement(Sentence sentence, int position, SyntaxStructure element) {
        sentence
                .getComponentList()
                .set(position, element);
    }

    /**
     * Method for finding first Word object in sentence
     * @param sentence sentence object to work with
     * @return index of found position
     */
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

    /**
     * Method for getting information about SyntaxStructure(is it Word or not)
     * @param structure SyntaxStructure object
     * @return true if structure is a word object, false otherwise
     */
    private static boolean isWord(SyntaxStructure structure) {
        return structure instanceof Word;
    }

    /**
     * Method for returning to the original text, which hasn't been changed
     * @param text text object to work with
     * @return original text object
     */
    public static Text rollback(Text text) {

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(OBJECT_STATE_FILE))) {

            text = (Text) inputStream.readObject();
        } catch (IOException ex) {
            log.error(IOEXCEPTION_LOG_MESSAGE + ex);
            System.out.println(IMPOSSIBLE_TO_READ_TEXT);
        } catch (ClassNotFoundException ex) {
            log.error(CLASS_NOT_FOUND_LOG_MESSAGE + ex);
            exit();
        }

        log.info(ROLLBACK_LOG_MESSAGE);
        return text;
    }

    /**
     * Method for saving text object state in file
     * @param text text object to save
     */
    public static void saveTextState(Text text) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(OBJECT_STATE_FILE))) {
            outputStream.writeObject(text);
        } catch (IOException ex) {
            log.error(IOEXCEPTION_LOG_MESSAGE + ex);
        }
    }

    /**
     * Method for printing text words in alphabetic sort
     * @param text text object to work with
     */
    public static void printSentenceWordsInAlphabeticSort(Text text) {
        List<String> sortedWords = new ArrayList<>();

        for (SyntaxStructure sentence : getSentences(text)) {
            addAllSentenceWordsAsStrings(sortedWords, sentence);
        }

        sortedWords = sortAndDistinctCollection(sortedWords);

        System.out.println(sortedWords.get(0));

        for (int i = 1; i < sortedWords.size(); i++) {
            String word = sortedWords.get(i);
            String previousWord = sortedWords.get(i - 1);
            if (word.charAt(0) != previousWord.charAt(0)) {
                System.out.print("\n\t" + word + WORDS_DELIMITER);
            } else {
                System.out.print("\s" + word + WORDS_DELIMITER);
            }
        }
        System.out.println("\n");
    }

    /**
     * Method for sorting words by alphabet and delete same words
     * @param collection list of words
     * @return list of sorted words
     */
    private static List<String> sortAndDistinctCollection(List<String> collection) {
        return collection
                .stream()
                .sorted()
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * Method for transformation Word objects to String and adding them to list
     * @param collection list to add words
     * @param sentence sentence object from where words should be taken
     */
    private static void addAllSentenceWordsAsStrings(List<String> collection, SyntaxStructure sentence) {
        collection.addAll(getSentenceWords((Sentence) sentence)
                .stream()
                .map(word -> word.getComponent()
                        .toLowerCase())
                .collect(Collectors.toList()));
    }
}
