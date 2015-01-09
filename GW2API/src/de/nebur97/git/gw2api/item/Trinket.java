package de.nebur97.git.gw2api.item;

import de.nebur97.git.gw2api.type.Type;
import de.nebur97.git.gw2api.type.trinket.TrinketType;

/**
 * A trinket.
 * 
 * @author NeBuR97
 * 
 */
public class Trinket extends Gear
{
    public Trinket(Item parent)
    {
	super(parent);
	setItemType(Type.TRINKET);
    }

    /**
     * Set this trinket's type.
     * 
     * @param t
     * @see TrinketType
     */
    public void setType(String t)
    {
	try{
	    setType(TrinketType.valueOf(t.toUpperCase()));
	}catch(Exception e)
	{
	    e.printStackTrace();
	}
	
    }
}
