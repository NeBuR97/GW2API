package de.nebur97.git.gw2api.item;

import de.nebur97.git.gw2api.type.consumable.ConsumableType;
import de.nebur97.git.gw2api.type.consumable.UnlockType;

/**
 * An object representing a consumable item.
 * 
 * @author NeBuR97
 **/
public class Consumable extends Item
{
    private long       durMS;
    private int	colorID;
    private int	recipeID;
    private UnlockType unlockType = UnlockType.NONE;
    
    public void setType(String t)
    {
	try {
	    setType(ConsumableType.valueOf(t.toUpperCase()));
	} catch(Exception e) {
	    e.printStackTrace();
	}
    }
    
    /**
     * Get this consumables unlock type.
     * 
     * @return UnlockType.NONE if this item unlocks nothing.
     * @see UnlockType
     */
    public UnlockType getUnlockType()
    {
	return unlockType;
    }
    
    /**
     * Set the unlock type.
     * 
     * @param ut
     */
    public void setUnlockType(UnlockType ut)
    {
	unlockType = ut;
    }
    
    /**
     * Set the unlock type defines in the string. The default value
     * {@link UnlockType#NONE} is used, if no type is found.
     * 
     * @param ut
     */
    public void setUnlockType(String ut)
    {
	try {
	    setUnlockType(UnlockType.valueOf(ut.toUpperCase()));
	} catch(Exception e) {
	    e.printStackTrace();
	}
    }
    
    /**
     * Effect duration in milliseconds.
     * 
     * @return duration in ms
     */
    public long getDurationMS()
    {
	return durMS;
    }
    
    /**
     * Set the effect duration.
     * 
     * @param durMS
     */
    public void setDurationMS(long durMS)
    {
	this.durMS = durMS;
    }
    
    /**
     * he dye id for dye unlocks.
     * 
     * @return dye id
     */
    public int getColorID()
    {
	return colorID;
    }
    
    /**
     * Set the unlockable dye's id.
     * 
     * @param colorID
     */
    public void setColorID(int colorID)
    {
	this.colorID = colorID;
    }
    
    /**
     * The recipe id for recipe unlocks.
     * 
     * @return recipe id
     */
    public int getRecipeID()
    {
	return recipeID;
    }
    
    /**
     * Set the unlockable recipe's id.
     * 
     * @param recipeID
     */
    public void setRecipeID(int recipeID)
    {
	this.recipeID = recipeID;
    }
}
