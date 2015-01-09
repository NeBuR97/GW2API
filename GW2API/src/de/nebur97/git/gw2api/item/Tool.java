package de.nebur97.git.gw2api.item;

import de.nebur97.git.gw2api.type.Type;

/**
 * A SalvageKit.
 * 
 * @author NeBuR97
 * @see Type#TOOL
 */
public class Tool extends Item
{
    public Tool(Item parent)
    {
	super(parent);
	setItemType(Type.TOOL);
    }

    private int charges;
    
    @Override
    public Type getType()
    {
	return Type.TOOL;
    }
    
    /**
     * Get the kit's charges.
     * 
     * @return charges
     */
    public int getCharges()
    {
	return charges;
    }
    
    /**
     * Set the kit'S charges.
     * 
     * @param charges
     */
    public void setCharges(int charges)
    {
	this.charges = charges;
    }
}
