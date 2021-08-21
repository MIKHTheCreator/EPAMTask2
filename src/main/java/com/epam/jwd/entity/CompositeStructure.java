package com.epam.jwd.entity;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CompositeStructure implements SyntaxStructure{

    private List<SyntaxStructure> componentList;

    public CompositeStructure(List<SyntaxStructure> componentList) {
        this.componentList = componentList;
    }

    public List<SyntaxStructure> getComponentList() {
        return componentList;
    }

    public void setComponentList(List<SyntaxStructure> componentList) {
        this.componentList = componentList;
    }

    public boolean removeComponent(SyntaxStructure structure){
        return componentList.remove(structure);
    }

    public SyntaxStructure removeComponent(int index){
        return componentList.remove(index);
    }

    public boolean addComponent(SyntaxStructure structure){
        return componentList.add(structure);
    }

    @Override
    public String getComponent() {
        return componentList
                .stream()
                .map(SyntaxStructure::getComponent)
                .collect(Collectors.joining());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositeStructure that = (CompositeStructure) o;
        return Objects.equals(componentList, that.componentList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(componentList);
    }

    @Override
    public String toString() {
        return new StringBuilder(this.getClass().getSimpleName())
                .append("{")
                .append("componentList=")
                .append(componentList)
                .append("}")
                .toString();
    }
}
