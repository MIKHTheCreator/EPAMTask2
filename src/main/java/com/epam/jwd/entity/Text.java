package com.epam.jwd.entity;

import java.util.List;
import java.util.Objects;

public class Text extends AbstractCompositeStructure {

    private static final String DEFAULT_TEXT_TYPE = "programming text";
    private String textType;

    public Text(List<SyntaxStructure> componentList) {
        super(componentList);
    }

    public String getTextType() {
        if ("".equals(textType)) {
            return DEFAULT_TEXT_TYPE;
        }

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
        return new StringBuilder("\n")
                .append(super.toString())
                .append("textType=")
                .append(textType)
                .toString();
    }
}
