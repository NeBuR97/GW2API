package de.nebur97.git.gw2api.item;

import de.nebur97.git.gw2api.type.trinket.TrinketType;

/**
 * A trinket.
 * 
 * @author NeBuR97
 * 
 */
public class Trinket extends Gear
{
    /**
     * Set this trinket's type.
     * 
     * @param t
     * @see TrinketType
     */
    public void setType(String t)
    {
	setType(TrinketType.valueOf(t.toUpperCase()));
    }
}
