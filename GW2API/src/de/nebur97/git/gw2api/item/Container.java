package de.nebur97.git.gw2api.item;

import de.nebur97.git.gw2api.type.container.ContainerType;

/**
 * An implementation of a container.
 * 
 * @author NeBuR97
 * 
 */
public class Container extends Item
{
    /**
     * Set this container's type.
     * 
     * @param ct
     */
    public void setType(String ct)
    {
	setType(ContainerType.valueOf(ct.toUpperCase()));
    }
}
