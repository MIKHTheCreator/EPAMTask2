package com.epam.jwd.entity;

import java.util.Objects;

/**
 * Entity class which keep inside punctuation mark as a symbol
 * @author Mikhail Kharevich
 */
public class PunctuationMark implements SyntaxStructure {

    private String character;

    /**
     * Constructor for creating punctuation mark as an object
     * @param character string visualisation of punctuation mark
     */
    public PunctuationMark(String character) {
        this.character = character;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    /**
     * {@link SyntaxStructure#getComponent()}
     * @return component as a string
     */
    @Override
    public String getComponent() {
        return character;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PunctuationMark that = (PunctuationMark) o;
        return Objects.equals(character, that.character);
    }

    @Override
    public int hashCode() {
        return Objects.hash(character);
    }

    @Override
    public String toString() {
        return new StringBuilder("\nPunctuation Mark: ")
                .append("'")
                .append(character)
                .append("'")
                .toString();
    }
}
