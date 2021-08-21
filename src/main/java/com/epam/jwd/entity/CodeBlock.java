package com.epam.jwd.entity;


import java.util.List;
import java.util.Objects;


public class CodeBlock extends CompositeStructure {

    private static final String DEFAULT_CODE_BLOCK_LANGUAGE = "undefined";
    private String codeBlockLanguage;

    public CodeBlock(List<SyntaxStructure> componentList) {
        super(componentList);
    }

    public String getCodeBlockLanguage() {
        if("".equals(codeBlockLanguage)){
            return DEFAULT_CODE_BLOCK_LANGUAGE;
        }

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
        return new StringBuilder("\n")
                .append(super.toString())
                .append("codeBlockLanguage=")
                .append(codeBlockLanguage)
                .toString();
    }
}
