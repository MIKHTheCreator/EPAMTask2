package com.epam.jwd.entity;

import java.util.List;
import java.util.Objects;

/**
 * Entity class which keeps inside text as a list of sentence objects
 * @author Mikhail Kharevich
 */
public class Text extends CompositeStructure {

    private static final String DEFAULT_TEXT_TYPE = "programming text";
    private String textType;

    /**
     * COnstructor for creating Text object using list of codeblocks and sentences
     * @param componentList list of codeblocks and sentences
     */
    public Text(List<SyntaxStructure> componentList) {
        super(componentList);
    }

    /**
     * Method for getting text type
     * @return text type as a string, if type wasn't provided returns {@value DEFAULT_TEXT_TYPE}
     */
    public String getTextType() {
        if ("".equals(textType)) {
            return DEFAULT_TEXT_TYPE;
        }

        return textType;
    }

    /**
     * Method for setting text type
     * @param textType type of text
     */
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
