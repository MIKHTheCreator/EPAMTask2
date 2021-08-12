package com.epam.jwd.entity;

import java.util.List;
import java.util.Objects;

public class CodeBlock {

    private String codeBlock;
    private List<CommonWord> wordList;
    private List<PunctuationMark> punctuationMarkList;

    public CodeBlock(String codeBlock, List<CommonWord> wordList, List<PunctuationMark> punctuationMarkList) {
        this.codeBlock = codeBlock;
        this.wordList = wordList;
        this.punctuationMarkList = punctuationMarkList;
    }

    public String getCodeBlock() {
        return codeBlock;
    }

    public void setCodeBlock(String codeBlock) {
        this.codeBlock = codeBlock;
    }

    public List<CommonWord> getWordList() {
        return wordList;
    }

    public void setWordList(List<CommonWord> wordList) {
        this.wordList = wordList;
    }

    public List<PunctuationMark> getPunctuationMarkList() {
        return punctuationMarkList;
    }

    public void setPunctuationMarkList(List<PunctuationMark> punctuationMarkList) {
        this.punctuationMarkList = punctuationMarkList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodeBlock codeBlock1 = (CodeBlock) o;
        return Objects.equals(codeBlock, codeBlock1.codeBlock)
                && Objects.equals(wordList, codeBlock1.wordList)
                && Objects.equals(punctuationMarkList, codeBlock1.punctuationMarkList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeBlock, wordList, punctuationMarkList);
    }

    @Override
    public String toString() {
        return new StringBuilder("\nCode Block = '")
                .append(codeBlock)
                .append("'")
                .toString();
    }
}
