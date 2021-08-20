package com.epam.jwd.entity;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Text implements SyntaxStructure {

    private List<SyntaxStructure> text;

    public Text(List<SyntaxStructure> text) {
        this.text = text;
    }

    public List<SyntaxStructure> getText() {
        return text;
    }

    public void setText(List<SyntaxStructure> text) {
        this.text = text;
    }

    @Override
    public String getComponent() {
        return text
                .stream()
                .map(SyntaxStructure::getComponent)
                .collect(Collectors.joining());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text text1 = (Text) o;
        return Objects.equals(text, text1.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

    @Override
    public String toString() {
        return new StringBuilder("\nText: ")
                .append("'")
                .append(getComponent())
                .append("'")
                .toString();
    }
}
