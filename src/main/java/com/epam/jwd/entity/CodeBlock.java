package com.epam.jwd.entity;


import java.util.List;
import java.util.Objects;

/**
 * Entity class which keep inside code block as a structure of words and punctuation marks
 * @author Mikhail Kharevich
 */
public class CodeBlock extends CompositeStructure {

    private static final String DEFAULT_CODE_BLOCK_LANGUAGE = "undefined";
    private String codeBlockLanguage;

    /**
     * Constructor that creates code block object
     * using a list of SyntaxStructure components such as words and punctuation marks
     * @param componentList words and punctuation marks(SyntaxStructure objects) as list
     */
    public CodeBlock(List<SyntaxStructure> componentList) {
        super(componentList);
    }

    /**
     * Methods provides user with code block programming language
     * which was set by class user
     * @return name of programming language as a string
     */
    public String getCodeBlockLanguage() {
        if("".equals(codeBlockLanguage)){
            return DEFAULT_CODE_BLOCK_LANGUAGE;
        }

        return codeBlockLanguage;
    }

    /**
     * Common setter that sets code block programming language
     * @param codeBlockLanguage programming language
     */
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
