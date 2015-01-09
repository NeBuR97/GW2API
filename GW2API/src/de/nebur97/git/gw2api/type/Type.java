package de.nebur97.git.gw2api.type;

import de.nebur97.git.gw2api.type.armor.ArmorType;
import de.nebur97.git.gw2api.type.consumable.ConsumableType;
import de.nebur97.git.gw2api.type.container.ContainerType;
import de.nebur97.git.gw2api.type.craftingmaterial.CraftingMaterialType;
import de.nebur97.git.gw2api.type.gathering.GatheringType;
import de.nebur97.git.gw2api.type.gizmo.GizmoType;
import de.nebur97.git.gw2api.type.trinket.TrinketType;
import de.nebur97.git.gw2api.type.upgradecomponent.UpgradeCompType;
import de.nebur97.git.gw2api.type.weapon.WeaponType;

/**
 * Possible item types.<br>
 * Names should be pretty self explanatory.<br>
 * Constants:<br>
 * <li>{@link #ARMOR} <li>{@link #BACK} <li>{@link #BAG} <li>{@link #CONSUMABLE}
 * <li>{@link #CONTAINER} <li>{@link #CRAFTINGMATERIAL} <li>{@link #GATHERING}
 * <li>{@link #GIZMO} <li>{@link #MINIPET} <li>{@link #TOOL} <li>{@link #TRAIT}
 * <li>{@link #TRINKET} <li>{@link #TROPHY} <li>{@link #UPGRADECOMPONENT} <li>
 * {@link #WEAPON}
 * 
 * @author NeBuR97
 * 
 **/
public enum Type
{
    
    /**
     * Armor.
     * 
     * @see de.nebur97.git.gw2api.type.armor.ARMOR ARMOR(enumeration)
     * @see de.nebur97.git.gw2api.item.Armor Armor(Item implementation)
     **/
    ARMOR {
	@Override
	public ArmorType getSubType(String type)
	{
	    try {
		return ArmorType.valueOf(type);
<<<<<<< HEAD
	    }
	    catch(Exception e) {
		// System.err.println(type+" is not a valid ArmorType!");
=======
	    }catch(Exception e)
	    {
		//System.err.println(type+" is not a valid ArmorType!");
>>>>>>> origin/master
		return null;
	    }
	}
    },
    
    /**
     * Back items.
     * 
     * @see de.nebur97.git.gw2api.item.Back Back
     */
    BACK {
	@Override
	public Type getSubType(String type)
	{
<<<<<<< HEAD
	    if(type.equals("BACK")) {
		return this;
	    }
	    return null;
=======
		if(type.equals("BACK"))
		{
			return this;
		}
		return null;
>>>>>>> origin/master
	}
    },
    
    /**
     * Inventory bags.
     * 
     * @see de.nebur97.git.gw2api.item.Bag Bag
     */
    BAG {
	@Override
	public Type getSubType(String type)
	{
<<<<<<< HEAD
	    if(type.equals("BAG")) {
		return this;
	    }
	    return null;
	}
    },
    
    /**
     * A bulk type.
     */
    BULK {
	@Override
	public Type getSubType(String type)
	{
	    if(type.equals("BULK")) {
		return this;
	    }
	    return null;
=======
		if(type.equals("BAG"))
		{
			return this;
		}
		return null;
>>>>>>> origin/master
	}
    },
    
    /**
     * Consumables.
     * 
     * @see de.nebur97.git.gw2api.type.consumable.CONSUMABLE
     * Consumable(enumeration)
     * @see de.nebur97.git.gw2api.item.Consumable Consumable(Item
     * implementation)
     */
    CONSUMABLE {
	@Override
	public ConsumableType getSubType(String type)
	{
	    try {
		return ConsumableType.valueOf(type);
<<<<<<< HEAD
	    }
	    catch(Exception e) {
		// System.err.println(type+" is not a valid ConsumableType!");
=======
	    }catch(Exception e)
	    {
		//System.err.println(type+" is not a valid ConsumableType!");
>>>>>>> origin/master
		return null;
	    }
	}
    },
    
    /**
     * Container.
     * 
     * @see de.nebur97.git.gw2api.item.Container Container
     */
    CONTAINER {
	@Override
	public ContainerType getSubType(String type)
	{
	    try {
		return ContainerType.valueOf(type);
<<<<<<< HEAD
	    }
	    catch(Exception e) {
		// System.err.println(type+" is not a valid ContainerType!");
=======
	    }catch(Exception e)
	    {
		//System.err.println(type+" is not a valid ContainerType!");
>>>>>>> origin/master
		return null;
	    }
	}
    },
    
    /**
     * Crafting material.
     * 
     * @see de.nebur97.git.gw2api.item.CraftingMaterial CraftingMaterial
     */
    CRAFTINGMATERIAL {
	@Override
	public CraftingMaterialType getSubType(String type)
	{
	    try {
		return CraftingMaterialType.valueOf(type);
<<<<<<< HEAD
	    }
	    catch(Exception e) {
		// System.err.println(type+" is not a valid CraftingMaterialType!");
=======
	    }catch(Exception e)
	    {
		//System.err.println(type+" is not a valid CraftingMaterialType!");
>>>>>>> origin/master
		return null;
	    }
	}
    },
    
    /**
     * A dye.
     */
    DYE {
	@Override
	public Type getSubType(String type)
	{
	    if(type.equals("DYE")) {
		return this;
	    }
	    return null;
	}
    },
    
    /**
     * Gathering tools.
     * 
     * @see de.nebur97.git.gw2api.item.Gathering Gathering
     */
    GATHERING {
	@Override
	public GatheringType getSubType(String type)
	{
	    try {
		return GatheringType.valueOf(type);
<<<<<<< HEAD
	    }
	    catch(Exception e) {
		// System.err.println(type+" is not a valid GatheringType!");
=======
	    }catch(Exception e)
	    {
		//System.err.println(type+" is not a valid GatheringType!");
>>>>>>> origin/master
		return null;
	    }
	}
    },
    
    /**
     * Gizmos.
     * 
     * @see de.nebur97.git.gw2api.item.Gizmo Gizmo
     */
    GIZMO {
	@Override
	public GizmoType getSubType(String type)
	{
	    try {
		return GizmoType.valueOf(type);
<<<<<<< HEAD
	    }
	    catch(Exception e) {
		// System.err.println(type+" is not a valid GizmoType!");
=======
	    }catch(Exception e)
	    {
		//System.err.println(type+" is not a valid GizmoType!");
>>>>>>> origin/master
		return null;
	    }
	}
    },
    
    /**
     * Miniatures.
     * 
     * @see de.nebur97.git.gw2api.item.MiniPet MiniPet
     */
    MINIPET {
	@Override
	public Type getSubType(String type)
	{
<<<<<<< HEAD
	    if(type.equals("MINIPET")) {
		return this;
	    }
	    return null;
	}
    },
    
    /**
     * No type.
     */
    NONE {
	@Override
	public Type getSubType(String type)
	{
	    if(type.equals("NONE")) {
		return this;
	    }
	    return null;
	}
    },
    
    /**
     * A potion.
     */
    POTION {
	@Override
	public Type getSubType(String type)
	{
	    if(type.equals("POTION")) {
		return this;
	    }
	    return null;
=======
		if(type.equals("MINIPET"))
		{
			return this;
		}
		return null;
>>>>>>> origin/master
	}
    },
    
    /**
     * Salvage kits.
     * 
     * @see de.nebur97.git.gw2api.item.Tool Tool
     */
    TOOL {
	@Override
	public Type getSubType(String type)
	{
<<<<<<< HEAD
	    if(type.equals("TOOL")) {
		return this;
	    }
	    return null;
=======
		if(type.equals("TOOL"))
		{
			return this;
		}
		return null;
>>>>>>> origin/master
	}
    },
    
    /**
     * Trait guides.
     * 
     * @see de.nebur97.git.gw2api.item.Trait Trait
     */
    TRAIT {
	@Override
	public Type getSubType(String type)
	{
<<<<<<< HEAD
	    if(type.equals("TRAIT")) {
		return this;
	    }
	    return null;
=======
		if(type.equals("TRAIT"))
		{
			return this;
		}
		return null;
>>>>>>> origin/master
	}
    },
    
    /**
     * Trinkets.
     * 
     * @see de.nebur97.git.gw2api.type.trinket.TRINKET Trinket(enum)
     * @see de.nebur97.git.gw2api.item.Trinket Trinket(Item impl)
     */
    TRINKET {
	@Override
	public TrinketType getSubType(String type)
	{
	    try {
		return TrinketType.valueOf(type);
<<<<<<< HEAD
	    }
	    catch(Exception e) {
		// System.err.println(type+" is not a valid TrinketType!");
=======
	    }catch(Exception e)
	    {
		//System.err.println(type+" is not a valid TrinketType!");
>>>>>>> origin/master
		return null;
	    }
	}
    },
    
    /**
     * Trophies.
     * 
     * @see de.nebur97.git.gw2api.item.Trophy Trophy
     */
    TROPHY {
	@Override
	public Type getSubType(String type)
	{
<<<<<<< HEAD
	    if(type.equals("TROPHY")) {
		return this;
	    }
	    return null;
=======
		if(type.equals("TROPHY"))
		{
			return this;
		}
		return null;
>>>>>>> origin/master
	}
    },
    
    /**
     * Upgrade components.
     * 
     * @see de.nebur97.git.gw2api.item.UpgradeComponent UpgradeComponent
     */
    UPGRADECOMPONENT {
	@Override
	public UpgradeCompType getSubType(String type)
	{
	    try {
		return UpgradeCompType.valueOf(type);
<<<<<<< HEAD
	    }
	    catch(Exception e) {
		// System.err.println(type+" is not a valid UpgradeCompType!");
=======
	    }catch(Exception e)
	    {
		//System.err.println(type+" is not a valid UpgradeCompType!");
>>>>>>> origin/master
		return null;
	    }
	}
    },
    
    /**
     * Weapons.
     * 
     * @see de.nebur97.git.gw2api.type.weapon.WEAPON Weapon(enum)
     * @see de.nebur97.git.gw2api.item.Weapon Weapon(Item impl)
     */
    WEAPON {
	@Override
	public WeaponType getSubType(String type)
	{
	    try {
		return de.nebur97.git.gw2api.type.weapon.WEAPON.getWeaponType(type);
<<<<<<< HEAD
	    }
	    catch(Exception e) {
		// System.err.println(e.getMessage());
		return null;
	    }
	}
=======
	    }catch(Exception e)
	    {
		//System.err.println(e.getMessage());
		return null;
	    }
	}
    },
    
    /**
     * No type.
     */
    NONE {
	@Override
	public Type getSubType(String type)
	{
		if(type.equals("NONE"))
		{
			return this;
		}
		return null;
	}
    },
    
    /**
     * A dye.
     */
    DYE {
	@Override
	public Type getSubType(String type)
	{
		if(type.equals("DYE"))
		{
			return this;
		}
		return null;
	}
    },
    
    /**
     * A potion.
     */
    POTION {
	@Override
	public Type getSubType(String type)
	{
		if(type.equals("POTION"))
		{
			return this;
		}
		return null;
	}
    },
    
    /**
     * A bulk type.
     */
    BULK {
	@Override
	public Type getSubType(String type)
	{
		if(type.equals("BULK"))
		{
			return this;
		}
		return null;
	}
>>>>>>> origin/master
    };
    
    /**
     * Returns the supertype of the type in the string, or NONE if no type is found.
     * @param type
     * @return
     */
    public static Object getType(String type)
    {
	String s = type.toUpperCase();
<<<<<<< HEAD
	try {
	    return Type.valueOf(s);
	}
	catch(Exception e) {
	    // 0 = Type, 1 = Subtype;
	    Object types[] = new Object[2];
	    for(Type t : Type.class.getEnumConstants()) {
		types[0] = t;
		if((types[1] = t.getSubType(s) ) != null) {
		    return types;
		}
	    }
	    return NONE;
=======
	try{
		return Type.valueOf(s);
	}catch(Exception e )
	{
		//0 = Type, 1 = Subtype;
		Object types[] = new Object[2];
		for(Type t : Type.class.getEnumConstants())
		{
			types[0] = t;
			if((types[1] = t.getSubType(s))!= null)
			{
				return types;
			}
		}
		return NONE;
>>>>>>> origin/master
	}
	
    }
    
    public abstract Object getSubType(String type);
}
