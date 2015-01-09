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
    private static final long serialVersionUID = -7842231480239949737L;
    
    private int charges;
    
    public Tool(Item parent)
    {
	super(parent);
	setItemType(Type.TOOL);
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
    
    @Override
    public Type getType()
    {
	return Type.TOOL;
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
