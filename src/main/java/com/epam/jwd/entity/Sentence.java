package com.epam.jwd.entity;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Sentence implements SyntaxStructure {

    private List<SyntaxStructure> sentence;

    public Sentence(List<SyntaxStructure> sentence) {
        this.sentence = sentence;
    }

    public List<SyntaxStructure> getSentence() {
        return sentence;
    }

    public void setSentence(List<SyntaxStructure> sentence) {
        this.sentence = sentence;
    }

    @Override
    public String getComponent() {
        return sentence.stream().map(SyntaxStructure::getComponent).collect(Collectors.joining());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sentence sentence1 = (Sentence) o;
        return Objects.equals(sentence, sentence1.sentence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sentence);
    }

    @Override
    public String toString() {
        return new StringBuilder("Sentence: ")
                .append("'")
                .append(getComponent())
                .append("'")
                .toString();
    }
}
