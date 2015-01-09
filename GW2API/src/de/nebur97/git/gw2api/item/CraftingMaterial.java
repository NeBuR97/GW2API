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
    private static final long serialVersionUID = -4117168351014478104L;
    
    public CraftingMaterial(Item parent)
    {
	super(parent);
    }
    
    @Override
    public Type getType()
    {
	return Type.CRAFTINGMATERIAL;
    }
}
