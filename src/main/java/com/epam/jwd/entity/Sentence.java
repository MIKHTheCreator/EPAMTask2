package com.epam.jwd.entity;

import java.util.List;

public class Sentence extends CompositeStructure {

    public Sentence(List<SyntaxStructure> componentList) {
        super(componentList);
    }

    public int getNumOfSentenceElements(){
        return super.getComponentList().size();
    }
}
