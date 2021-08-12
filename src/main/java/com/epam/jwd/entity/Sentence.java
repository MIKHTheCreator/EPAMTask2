package com.epam.jwd.entity;

import java.util.List;
import java.util.Objects;

public class Sentence {

    private String sentence;
    private List<PunctuationMark> punctuationMarkList;
    private List<CommonWord> wordList;

    public Sentence(String sentence, List<PunctuationMark> punctuationMarkList, List<CommonWord> wordList) {
        this.sentence = sentence;
        this.punctuationMarkList = punctuationMarkList;
        this.wordList = wordList;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public List<PunctuationMark> getPunctuationMarkList() {
        return punctuationMarkList;
    }

    public void setPunctuationMarkList(List<PunctuationMark> punctuationMarkList) {
        this.punctuationMarkList = punctuationMarkList;
    }

    public List<CommonWord> getWordList() {
        return wordList;
    }

    public void setWordList(List<CommonWord> wordList) {
        this.wordList = wordList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sentence sentence1 = (Sentence) o;
        return Objects.equals(sentence, sentence1.sentence)
                && Objects.equals(punctuationMarkList, sentence1.punctuationMarkList)
                && Objects.equals(wordList, sentence1.wordList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sentence, punctuationMarkList, wordList);
    }

    @Override
    public String toString() {
        return new StringBuilder("\nSentence = '")
                .append(sentence)
                .append("'")
                .toString();
    }
}
