package de.nebur97.git.gw2api.item;

import de.nebur97.git.gw2api.type.Type;

/**
 * A trophy.
 * 
 * @author NeBuR97
 * @see Type#TROPHY
 */
public class Trophy extends Item
{
    public Trophy(Item parent)
    {
	super(parent);
	setItemType(Type.TROPHY);
    }

    @Override
    public Type getType()
    {
	return Type.TROPHY;
    }
}
