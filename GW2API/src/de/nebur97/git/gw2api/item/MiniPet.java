package de.nebur97.git.gw2api.item;

import de.nebur97.git.gw2api.type.Type;

/**
 * A miniature.
 * 
 * @author NeBuR97
 * 
 */
public class MiniPet extends Item
{
    public MiniPet(Item parent)
    {
	super(parent);
	setItemType(Type.MINIPET);
    }

    @Override
    public Type getType()
    {
	return Type.MINIPET;
    }
}
