package com.epam.jwd.entity.impl;

import com.epam.jwd.entity.api.SyntaxStructure;

import java.util.List;

/**
 * Entity class which keep inside sentence as a list of words and punctuation marks
 * @author Mikhail Kharevich
 */
public class Sentence extends CompositeStructure {

    /**
     * Constructor for creating object of sentence as a structure of words and punctuation marks
     * @param componentList list of word and punctuation mark objects
     */
    public Sentence(List<SyntaxStructure> componentList) {
        super(componentList);
    }

    /**
     * Method which count number of sentence elements such as words and punctuation marks
     * @return number of elements as int value
     */
    public int getNumOfSentenceElements() {
        return super.getComponentList().size();
    }
}
