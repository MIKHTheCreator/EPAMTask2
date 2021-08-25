package com.epam.jwd.entity;

import java.util.Objects;

/**
 * Entity class which keeps inside word as a string
 * @author Mikhail Kharevich
 */
public class Word implements SyntaxStructure {

    private String word;

    /**
     * Constructor which creates word object from string
     * @param word word
     */
    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    /**
     * {@link SyntaxStructure#getComponent()}
     * @return word as a string
     */
    @Override
    public String getComponent() {
        return word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return Objects.equals(word, word1.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }

    @Override
    public String toString() {
        return new StringBuilder("\nWord: ")
                .append("'")
                .append(word)
                .append("'")
                .toString();
    }
}
