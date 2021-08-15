package com.epam.jwd.entity;

import java.util.Objects;

public class PunctuationMark implements SyntaxStructure{

    private String character;

    public PunctuationMark(String character) {
        this.character = character;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    @Override
    public void getStructureAsText() {
        System.out.print(character);
    }

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
        return character;
    }
}
