package com.epam.jwd.entity;

import java.util.List;
import java.util.Objects;

public class Text {

    private String text;
    private List<Sentence> listOfSentences;
    private List<CodeBlock> codeBlockList;

    public Text(String text, List<Sentence> listOfSentences, List<CodeBlock> codeBlockList) {
        this.text = text;
        this.listOfSentences = listOfSentences;
        this.codeBlockList = codeBlockList;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Sentence> getListOfSentences() {
        return listOfSentences;
    }

    public void setListOfSentences(List<Sentence> listOfSentences) {
        this.listOfSentences = listOfSentences;
    }

    public List<CodeBlock> getCodeBlockList() {
        return codeBlockList;
    }

    public void setCodeBlockList(List<CodeBlock> codeBlockList) {
        this.codeBlockList = codeBlockList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text text1 = (Text) o;
        return Objects.equals(text, text1.text)
                && Objects.equals(listOfSentences, text1.listOfSentences)
                && Objects.equals(codeBlockList, text1.codeBlockList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, listOfSentences, codeBlockList);
    }

    @Override
    public String toString() {
        return new StringBuilder("\nText = '")
                .append(text)
                .append("'")
                .toString();
    }
}
