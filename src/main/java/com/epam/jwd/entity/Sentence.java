package com.epam.jwd.entity;

import java.util.List;
import java.util.Objects;

public class Sentence {

    private String sentence;
    private List<Character> listOfPunctuationMarks;
    private List<String> listOfWords;

    public Sentence(String sentence, List<Character> listOfPunctuationMarks, List<String> listOfWords) {
        this.sentence = sentence;
        this.listOfPunctuationMarks = listOfPunctuationMarks;
        this.listOfWords = listOfWords;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public List<Character> getListOfPunctuationMarks() {
        return listOfPunctuationMarks;
    }

    public void setListOfPunctuationMarks(List<Character> listOfPunctuationMarks) {
        this.listOfPunctuationMarks = listOfPunctuationMarks;
    }

    public List<String> getListOfWords() {
        return listOfWords;
    }

    public void setListOfWords(List<String> listOfWords) {
        this.listOfWords = listOfWords;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sentence sentence1 = (Sentence) o;
        return Objects.equals(sentence, sentence1.sentence)
                && Objects.equals(listOfPunctuationMarks, sentence1.listOfPunctuationMarks)
                && Objects.equals(listOfWords, sentence1.listOfWords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sentence, listOfPunctuationMarks, listOfWords);
    }

    @Override
    public String toString() {
        return new StringBuilder("\nSentence = '")
                .append(sentence)
                .append("'")
                .toString();
    }
}
