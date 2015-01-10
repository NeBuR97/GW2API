package de.nebur97.git.gw2api.item;

import de.nebur97.git.gw2api.type.Type;
import de.nebur97.git.gw2api.type.consumable.ConsumableType;
import de.nebur97.git.gw2api.type.consumable.UnlockType;

/**
 * An object representing a consumable item.
 * 
 * @author NeBuR97
 **/
public class Consumable extends Item
{
    private static final long serialVersionUID = -2755684123581197910L;
    
    private int colorID;
    
    private long durMS;
    private int recipeID;
    private UnlockType unlockType = UnlockType.NONE;
    
    public Consumable(Item parent)
    {
	super(parent);
	setItemType(Type.CONSUMABLE);
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
     * Effect duration in milliseconds.
     * 
     * @return duration in ms
     */
    public long getDurationMS()
    {
	return durMS;
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
     * Set the unlockable dye's id.
     * 
     * @param colorID
     */
    public void setColorID(int colorID)
    {
	this.colorID = colorID;
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
     * Set the unlockable recipe's id.
     * 
     * @param recipeID
     */
    public void setRecipeID(int recipeID)
    {
	this.recipeID = recipeID;
    }
    
    public void setType(String t)
    {
	try {
	    setType(ConsumableType.valueOf(t.toUpperCase()));
	}
	catch(Exception e) {
	    e.printStackTrace();
	}
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
	}
	catch(Exception e) {
	    e.printStackTrace();
	}
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
}
