package de.nebur97.git.gw2api.item;

import de.nebur97.git.gw2api.type.Type;
import de.nebur97.git.gw2api.type.gathering.GatheringType;

/**
 * Gathering tool.
 * 
 * @author NeBuR97
 * 
 */
public class Gathering extends Item
{
    
    public Gathering(Item parent)
    {
	super(parent);
	setItemType(Type.GATHERING);
    }

    /**
     * @see #setType(String)
     * @param t
     */
    public void setType(String s)
    {
	try{
	    setType(GatheringType.valueOf(s.toUpperCase()));
	}catch(Exception e)
	{
	    e.printStackTrace();
	}
	
    }
}
