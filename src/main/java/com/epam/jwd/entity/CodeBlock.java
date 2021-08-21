package com.epam.jwd.entity;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CodeBlock implements SyntaxStructure {

    private List<SyntaxStructure> codeBlock;

    public CodeBlock(List<SyntaxStructure> codeBlock) {
        this.codeBlock = codeBlock;
    }

    public List<SyntaxStructure> getCodeBlock() {
        return codeBlock;
    }

    public void setCodeBlock(List<SyntaxStructure> codeBlock) {
        this.codeBlock = codeBlock;
    }

    public boolean removeComponent(SyntaxStructure structure){
        return codeBlock.remove(structure);
    }

    public SyntaxStructure removeComponent(int index){
        return codeBlock.remove(index);
    }

    public boolean addComponent(SyntaxStructure structure){
        return codeBlock.add(structure);
    }

    @Override
    public String getComponent() {
        return codeBlock
                .stream()
                .map(SyntaxStructure::getComponent)
                .collect(Collectors.joining());
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
        return new StringBuilder("Code Block: ")
                .append("'")
                .append(getComponent())
                .append("'")
                .toString();
    }
}
