package com.epam.jwd.entity;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Sentence implements SyntaxStructure{

    private List<SyntaxStructure> listOfComponents;

    public Sentence(SyntaxStructure... components) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sentence sentence = (Sentence) o;
        return Objects.equals(listOfComponents, sentence.listOfComponents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listOfComponents);
    }

    @Override
    public String toString() {
        return listOfComponents.stream().toString();
    }
}
