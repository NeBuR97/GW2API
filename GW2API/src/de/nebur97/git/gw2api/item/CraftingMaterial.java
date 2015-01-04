package de.nebur97.git.gw2api.item;

import de.nebur97.git.gw2api.type.Type;

/**
 * A crafting material.
 * 
 * @author NeBuR97
 * 
 */
public class CraftingMaterial extends Item
{
    
    @Override
    public Type getType()
    {
	return Type.CRAFTINGMATERIAL;
    }
}
