package com.epam.jwd.entity;

import java.util.Objects;

public class CodeBlock extends CompositeSyntaxStructure implements SyntaxStructure {

    private String codeBlockLanguage;

    public CodeBlock(String codeBlockLanguage, SyntaxStructure... components) {
        super(components);
        this.codeBlockLanguage = codeBlockLanguage;
    }

    public String getCodeBlockLanguage() {
        return codeBlockLanguage;
    }

    public void setCodeBlockLanguage(String codeBlockLanguage) {
        this.codeBlockLanguage = codeBlockLanguage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CodeBlock codeBlock = (CodeBlock) o;
        return Objects.equals(codeBlockLanguage, codeBlock.codeBlockLanguage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), codeBlockLanguage);
    }

    @Override
    public String toString() {
        return new StringBuilder(super.toString())
                .append("Code Block Programming Language: ")
                .append(codeBlockLanguage)
                .toString();
    }
}
