package com.epam.jwd.entity;

import java.util.Objects;

public class Word implements SyntaxStructure{

    private String word;
    private int numOfSymbols;

    public Word(String word) {
        this.word = word;
        this.numOfSymbols = word.length();
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
        this.numOfSymbols = word.length();
    }

    public int getNumOfSymbols() {
        return numOfSymbols;
    }

    @Override
    public void getStructure() {
        System.out.print(word + "\s");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return numOfSymbols == word1.numOfSymbols && Objects.equals(word, word1.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, numOfSymbols);
    }

    @Override
    public String toString() {
        return new StringBuilder("'")
                .append(word)
                .append("'")
                .toString();
    }
}
