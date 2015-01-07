package de.nebur97.git.gw2api.item;

import java.util.ArrayList;
import java.util.List;

import de.nebur97.git.gw2api.item.attributes.Attribute;
import de.nebur97.git.gw2api.item.infusions.Infusable;
import de.nebur97.git.gw2api.item.infusions.Infusion;
import de.nebur97.git.gw2api.type.armor.ArmorType;

/**
 * Wearable items (Armor and such).
 * 
 * @author NeBuR97
 * 
 */
public class Gear extends Item implements Infusable
{
    public Gear(Item parent)
    {
	super(parent);
    }

    private List<Attribute> stats = new ArrayList<Attribute>();
    private List<Infusion> iF = new ArrayList<Infusion>();
    private int suffixID;
    
    /**
     * Get an array containing all added attributes.
     * 
     * @return an array of Attributes
     */
    public ArrayList<Attribute> getAttributes()
    {
    	return new ArrayList<Attribute>(stats);
    }
    
    /**
     * Adds an Attribute.
     * 
     * @param a
     * - The Attribute to add.
     */
    public void addAttribute(Attribute a)
    {
	stats.add(a);
    }
    
    /**
     * Get the suffix item ID, usally an {@link UpgradeComponent}
     * 
     * @return suffix ID
     */
    public int getSuffixID()
    {
	return suffixID;
    }
    
    /**
     * Set the suffix ID
     * 
     * @param suffixID
     * - the suffix ID
     */
    public void setSuffixID(int suffixID)
    {
	this.suffixID = suffixID;
    }
    
    @Override
    public void setProperty(String prop, Object value)
    {
	switch(prop)
	{
	case "infusion_slots":
	    addInfusionSlot(value.toString());
	    break;
	case "attribute":
	    addAttribute((Attribute)value);
	    break;
	case "suffix_item_id":
	    suffixID = (Integer)value;
	    break;
	default: super.setProperty(prop, value);
	}
	    
    }

    @Override
    public void addInfusionSlot(Infusion inf)
    {
	iF.add(inf);
    }

    @Override
    public void addInfusionSlot(String inf)
    {
	try{
	    iF.add(Infusion.valueOf(inf));
	}catch(Exception e)
	{
	    iF.add(Infusion.NONE);
	}
    }

    @Override
    public List<Infusion> getInfusionSlots()
    {
    	if(iF.isEmpty())
    	{
    		iF.add(Infusion.NONE);
    	}
    	return new ArrayList<Infusion>(iF);
    }
}
