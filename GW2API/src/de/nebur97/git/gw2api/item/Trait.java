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
    @Override
    public Type getType()
    {
	return Type.TRAIT;
    }
}
