package de.nebur97.git.gw2api.item;

import de.nebur97.git.gw2api.type.armor.ArmorType;
import de.nebur97.git.gw2api.type.armor.WeightClass;

/**
 * An object representing a piece of Armor.
 * 
 * @see de.nebur97.git.gw2api.type.armor.ARMOR Possible Armor types
 * @see de.nebur97.git.gw2api.item.Item Item
 * @author NeBuR97
 **/
public class Armor extends Gear
{
    private int	 def;
    private WeightClass wClass;
    
    /**
     * Gets the armor's defense value.
     * 
     * @return defense
     */
    public int getDefense()
    {
	return def;
    }
    
    /**
     * Sets the armor's defense value.
     * 
     * @param def
     */
    public void setDefense(int def)
    {
	this.def = def;
    }
    
    /**
     * Gets the armor's weight class.
     * 
     * @return wClass
     * @see de.nebur97.git.gw2api.type.armor.WeightClass WeightClass
     */
    public WeightClass getWeightClass()
    {
	return wClass;
    }
    
    /**
     * Sets the weight class.
     * 
     * @param wClass
     * @see de.nebur97.git.gw2api.type.armor.WeightClass WeightClass
     */
    public void setWeightClass(String wClass)
    {
	this.wClass = WeightClass.valueOf(wClass.toUpperCase());
    }
    
    public void setType(String type)
    {
	setType(ArmorType.valueOf(type.toUpperCase()));
    }
    
}
