package com.epam.jwd.entity;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Text implements SyntaxStructure{

    private List<SyntaxStructure> listOfComponents;

    public Text(SyntaxStructure... components) {
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

    public void addComponent(List<? extends SyntaxStructure> components){
        listOfComponents.addAll(components);
    }

    public boolean removeComponent(SyntaxStructure component){
        return listOfComponents.remove(component);
    }

    public int getNumOfComponents(){
        return listOfComponents.size();
    }

    @Override
    public void getStructure() {
        listOfComponents.forEach(SyntaxStructure::getStructure);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text text = (Text) o;
        return Objects.equals(listOfComponents, text.listOfComponents);
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
