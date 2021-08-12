package com.epam.jwd.entity;

import java.util.Objects;

public class CommonWord {

    private String word;

    public CommonWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommonWord that = (CommonWord) o;
        return Objects.equals(word, that.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }

    @Override
    public String toString() {
        return new StringBuilder("\nWord = '")
                .append(word)
                .append("'")
                .toString();
    }
}
