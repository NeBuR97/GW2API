package de.nebur97.git.gw2api.item;

import de.nebur97.git.gw2api.type.Type;

/**
 * An object representing a back item.
 * 
 * @author NeBuR97
 * 
 */
public class Back extends Gear
{
    /*
     * Everything needed is implemented in Gear.
     * This class is just for organization.
     */
    
    public Back(Item parent)
    {
	super(parent);
	setItemType(Type.BACK);
    }

    @Override
    public Type getType()
    {
	return Type.BACK;
    }
}
