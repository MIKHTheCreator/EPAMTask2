package com.epam.jwd.entity.api;

import java.io.Serializable;

/**
 * Interface which set common behave for all entity elements
 * @author Mikhail Kharevich
 */
public interface SyntaxStructure extends Serializable {

    /**
     * Method which make String from component
     * @return component as a string
     */
    String getComponent();
}
