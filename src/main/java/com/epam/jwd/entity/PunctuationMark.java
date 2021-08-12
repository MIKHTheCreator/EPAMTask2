package com.epam.jwd.entity;

import java.util.Objects;

public class PunctuationMark {

    private char character;

    public PunctuationMark(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PunctuationMark that = (PunctuationMark) o;
        return character == that.character;
    }

    @Override
    public int hashCode() {
        return Objects.hash(character);
    }

    @Override
    public String toString() {
        return new StringBuilder("\nPunctuation Mark = '")
                .append(character)
                .append("'")
                .toString();
    }
}
