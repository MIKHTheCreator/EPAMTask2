package com.epam.jwd.entity;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Entity class which keep common information about all composite classes in structure
 * @author Mikhail Kharevich
 */
public class CompositeStructure implements SyntaxStructure {

    private List<SyntaxStructure> componentList;

    /**
     * Constructor which creates any composite object due to list of its components
     * @param componentList list of parts of whole composite structure
     */
    public CompositeStructure(List<SyntaxStructure> componentList) {
        this.componentList = componentList;
    }

    public List<SyntaxStructure> getComponentList() {
        return componentList;
    }

    public void setComponentList(List<SyntaxStructure> componentList) {
        this.componentList = componentList;
    }

    /**
     * Method to remove component from list of components by name
     * @param structure component to remove
     * @return was component remove successfully or not
     */
    public boolean removeComponent(SyntaxStructure structure) {
        return componentList.remove(structure);
    }

    /**
     * Method to remove component from list of components by index
     * @param index component position in the list of components
     * @return removed component
     */
    public SyntaxStructure removeComponent(int index) {
        return componentList.remove(index);
    }

    /**
     * Method for adding component in list of components
     * @param structure element to add
     * @return was element successfully add or not
     */
    public boolean addComponent(SyntaxStructure structure) {
        return componentList.add(structure);
    }

    /**
     * Implemented  method which provides user with getting
     * components as a string calling method of each structure by its own
     * @return whole structure as String
     */
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
