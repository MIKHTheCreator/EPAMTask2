package com.epam.jwd.entity;

import java.util.Objects;

public class Text extends CompositeSyntaxStructure implements SyntaxStructure{

    private String textType;

    public Text(String textType, SyntaxStructure... components) {
        super(components);
        this.textType = textType;
    }

    public String getTextType() {
        return textType;
    }

    public void setTextType(String textType) {
        this.textType = textType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Text text = (Text) o;
        return Objects.equals(textType, text.textType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), textType);
    }

    @Override
    public String toString() {
        return new StringBuilder(super.toString())
                .append("Type of Text: ")
                .append(textType)
                .toString();
    }
}
