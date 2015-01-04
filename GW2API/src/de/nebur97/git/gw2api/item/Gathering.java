package de.nebur97.git.gw2api.item;

import de.nebur97.git.gw2api.type.gathering.GatheringType;

/**
 * Gathering tool.
 * 
 * @author NeBuR97
 * 
 */
public class Gathering extends Item
{
    
    /**
     * @see #setType(String)
     * @param t
     */
    public void setType(String s)
    {
	setType(GatheringType.valueOf(s.toUpperCase()));
    }
}
