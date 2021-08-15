package com.epam.jwd.entity;

import java.util.Objects;

public class Sentence extends CompositeSyntaxStructure implements SyntaxStructure {

    private boolean isSimple;

    public Sentence(boolean isSimple, SyntaxStructure... components) {
        super(components);
        this.isSimple = isSimple;
    }

    public boolean isSimple() {
        return isSimple;
    }

    public void setSimple(boolean simple) {
        isSimple = simple;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Sentence sentence = (Sentence) o;
        return isSimple == sentence.isSimple;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isSimple);
    }

    @Override
    public String toString() {
        return new StringBuilder(super.toString())
                .append("Simple Sentence: ")
                .append(isSimple)
                .toString();
    }
}
