package com.epam.jwd.entity;

import java.util.Objects;

public class CodeBlock implements SyntaxStructure {

    private String codeBlock;

    public CodeBlock(String codeBlock) {
        this.codeBlock = codeBlock;
    }

    public String getCodeBlock() {
        return codeBlock;
    }

    public void setCodeBlock(String codeBlock) {
        this.codeBlock = codeBlock;
    }

    public int getCodeBlockSize() {
        return (int) codeBlock.lines().filter(s -> s.equals("\n")).count();
    }

    @Override
    public void getStructure() {
        System.out.print(codeBlock +"\s");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodeBlock codeBlock1 = (CodeBlock) o;
        return Objects.equals(codeBlock, codeBlock1.codeBlock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeBlock);
    }

    @Override
    public String toString() {
        return codeBlock;
    }
}
