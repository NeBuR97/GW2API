package de.nebur97.git.gw2api.type.container;

/**
 * Possible types of container.
 * 
 * @author NeBuR97
 * 
 */
public enum ContainerType
{
    DEFAULT,
    
    /**
     * For some presents and most dye kits,
     */
    GIFTBOX,
    
    /**
     * For containers that have their own UI when opening (Black Lion Chest).
     */
    OPENUI;
}
