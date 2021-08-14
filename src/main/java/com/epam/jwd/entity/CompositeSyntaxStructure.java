package com.epam.jwd.entity;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class CompositeSyntaxStructure implements SyntaxStructure{

    private List<SyntaxStructure> listOfComponents;

    public CompositeSyntaxStructure(SyntaxStructure... components) {
        addComponent(components);
    }

    public List<SyntaxStructure> getListOfComponents() {
        return listOfComponents;
    }

    public void setListOfComponents(List<SyntaxStructure> listOfComponents) {
        this.listOfComponents = listOfComponents;
    }

    public void addComponent(SyntaxStructure component){
        listOfComponents.add(component);
    }

    public void addComponent(SyntaxStructure... components){
        listOfComponents.addAll(Arrays.asList(components));
    }

    public boolean removeComponent(SyntaxStructure component){
        return listOfComponents.remove(component);
    }

    @Override
    public void getStructure() {
        listOfComponents.forEach(SyntaxStructure::getStructure);
    }

    public int getNumOfComponents(){
        return listOfComponents.size();
    }

    public void getStructureAsText(){
        getListOfComponents().forEach(syntaxStructure -> System.out.print(syntaxStructure + " "));

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositeSyntaxStructure that = (CompositeSyntaxStructure) o;
        return Objects.equals(listOfComponents, that.listOfComponents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listOfComponents);
    }

    @Override
    public String toString() {
        return "CompositeSyntaxStructure{" +
                "listOfComponents=" + listOfComponents +
                '}';
    }
}