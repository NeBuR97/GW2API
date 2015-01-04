package de.nebur97.git.gw2api.item;

import java.util.ArrayList;
import java.util.List;

import de.nebur97.git.gw2api.item.attributes.Attribute;
import de.nebur97.git.gw2api.item.infusions.Infusable;
import de.nebur97.git.gw2api.item.infusions.Infusion;

public class Gear extends Item implements Infusable
{
    private List<Attribute> stats = new ArrayList<Attribute>();
    private Infusion	iF    = Infusion.NONE;
    private int	     suffixID;
    
    /**
     * Get an array containing all added attributes.
     * 
     * @return an array of Attributes
     */
    public Attribute[] getAttributes()
    {
	return stats.toArray(new Attribute[stats.size()]);
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
    public void setInfusionSlot(Infusion inf)
    {
	iF = inf;
    }
    
    @Override
    public void setInfusionSlot(String infusion)
    {
	try {
	    setInfusionSlot(Infusion.valueOf(infusion.toUpperCase()));
	} catch(Exception e) {
	    e.printStackTrace();
	    setInfusionSlot(Infusion.AGONY);
	}
    }
    
    @Override
    public Infusion getInfusionSlot()
    {
	return iF;
    }
}
