package de.nebur97.git.gw2api.item;

import de.nebur97.git.gw2api.type.Type;

/**
 * A trait guide.
 * 
 * @author NeBuR97
 * 
 */
public class Trait extends Item
{
    public Trait(Item parent)
    {
	super(parent);
	setItemType(Type.TRAIT);
    }

    @Override
    public Type getType()
    {
	return Type.TRAIT;
    }
}
