package de.nebur97.git.gw2api.item;

import de.nebur97.git.gw2api.type.Type;
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
    private static final long serialVersionUID = 2484690254290587234L;
    
    private int def;
    
    private WeightClass wClass;
    
    public Armor(Item parent)
    {
	super(parent);
	setItemType(Type.ARMOR);
    }
    
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
     * Sets the armor's defense value.
     * 
     * @param def
     */
    public void setDefense(int def)
    {
	this.def = def;
    }
    
    @Override
    public void setProperty(String prop, Object value)
    {
	switch(prop)
	{
	    case "defense":
		def = (Integer) value;
		break;
	    case "weight_class":
		setWeightClass(value.toString());
		break;
	    default:
		super.setProperty(prop, value);
	}
    }
    
    /**
     * @see Item#setType(Object)
     * @param type
     */
    public void setType(String type)
    {
	try {
	    setType(ArmorType.valueOf(type.toUpperCase()));
	}
	catch(Exception e) {
	    e.printStackTrace();
	}
	
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
    
    protected String name()
    {
	return "Armor";
    }
}
