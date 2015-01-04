package de.nebur97.git.gw2api.item;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import de.nebur97.git.gw2api.item.flags.Flag;
import de.nebur97.git.gw2api.item.gametypes.GameType;
import de.nebur97.git.gw2api.item.restrictions.Restriction;
import de.nebur97.git.gw2api.rarity.Rarity;

/**
 * The basic item implementation.<br>
 * All other item types extend this.<br>
 * List of subtypes:<br>
 * <li>{@link Armor} <li>{@link Back} <li>{@link Bag} <li>{@link Consumable} <li>
 * {@link Container} <li>{@link CraftingMaterial} <li>{@link Gathering} <li>
 * {@link Gizmo} <li>{@link MiniPet} <li>{@link Tool} <li>{@link Trait} <li>
 * {@link Trinket} <li>{@link Trophy} <li>{@link UpgradeComponent} <li>
 * {@link Weapon}
 * 
 * @author NeBuR97
 **/
class Item
{
    private int	       id;
    private String	    name;
    private Object	    type;
    private URL	       icon;
    private String	    desc;
    private Rarity	    rare;
    private int	       level;
    private int	       vendorValue;
    private List<GameType>    gameTypes    = new ArrayList<GameType>();
    private List<Flag>	flags	= new ArrayList<Flag>();
    private List<Restriction> restrictions = new ArrayList<Restriction>();
    
    /**
     * Gets the item's id.
     * 
     * @return id
     */
    public int getID()
    {
	return id;
    }
    
    /**
     * Sets the item's id.
     * 
     * @param id
     */
    public void setID(int id)
    {
	this.id = id;
    }
    
    /**
     * Gets the item's name.
     * 
     * @return name
     */
    public String getName()
    {
	return name;
    }
    
    /**
     * Sets the item's name.
     * 
     * @param name
     */
    public void setName(String name)
    {
	this.name = name;
    }
    
    /**
     * Gets the item's Type.
     * 
     * @return one of the enum constants in Type or a specific subtype
     * @see de.nebur97.git.gw2api.type.Type Type
     */
    public Object getType()
    {
	return type;
    }
    
    /**
     * Sets the item's type.
     * 
     * @param type
     * @see de.nebur97.git.gw2api.type.Type Type
     */
    public void setType(Object type)
    {
	this.type = type;
    }
    
    /**
     * Gets the item's icon
     * 
     * @return icon
     */
    public URL getIcon()
    {
	return icon;
    }
    
    /**
     * Sets the item's icon URL.
     * 
     * @param icon
     */
    public void setIcon(URL icon)
    {
	this.icon = icon;
    }
    
    /**
     * Gets the item's description.
     * 
     * @return description
     */
    public String getDescription()
    {
	return desc;
    }
    
    /**
     * Sets the item's description.
     * 
     * @param desc
     */
    public void setDescription(String desc)
    {
	this.desc = desc;
    }
    
    /**
     * Gets the item's Rarity.
     * 
     * @return rarity
     * @see de.nebur97.git.gw2api.rarity.Rarity Rarity
     */
    public Rarity getRarity()
    {
	return rare;
    }
    
    /**
     * Sets the item's rarity.
     * 
     * @param rarity
     * @see de.nebur97.git.gw2api.rarity.Rarity Rarity
     */
    public void setRarity(Rarity rare)
    {
	this.rare = rare;
    }
    
    /**
     * Gets the item'slevel.
     * 
     * @return level
     */
    public int getLevel()
    {
	return level;
    }
    
    /**
     * Sets the item's level.
     * 
     * @param level
     */
    public void setLevel(int level)
    {
	this.level = level;
    }
    
    /**
     * Get the item's vendor sell value.
     * 
     * @return vendor sell value
     */
    public int getVendorValue()
    {
	return vendorValue;
    }
    
    /**
     * Set the item's sell value.
     * 
     * @param vendorValue
     */
    public void setVendorValue(int vendorValue)
    {
	this.vendorValue = vendorValue;
    }
    
    /**
     * Adds a game type
     * 
     * @param gT
     * @see GameType
     */
    public void addGameType(GameType gT)
    {
	gameTypes.add(gT);
    }
    
    /**
     * Adds the game type defined in the string. Does nothing if no game type is
     * found.
     * 
     * @param gT
     */
    public void addGameType(String gT)
    {
	try {
	    addGameType(GameType.valueOf(gT.toUpperCase()));
	} catch(Exception e) {
	    e.printStackTrace();
	}
    }
    
    /**
     * Get an all game types for this item.
     * 
     * @return an array of game types
     * @see GameType
     */
    public GameType[] getGameTypes()
    {
	return gameTypes.toArray(new GameType[gameTypes.size()]);
    }
    
    /**
     * Adds a flag.
     * 
     * @param f
     * @see Flag
     */
    public void addFlag(Flag f)
    {
	flags.add(f);
    }
    
    /**
     * Adds the flag named in the string. Does nothing if no flag is found.
     * 
     * @param f
     * @see #addFlag(Flag)
     */
    public void addFlag(String f)
    {
	try {
	    addFlag(Flag.valueOf(f.toUpperCase()));
	} catch(Exception e) {
	    e.printStackTrace();
	}
    }
    
    /**
     * Gets an array of all flags this item has.
     * 
     * @return an array of flags
     */
    public Flag[] getFlags()
    {
	return flags.toArray(new Flag[flags.size()]);
    }
    
    /**
     * Adds a restriction.
     * 
     * @param r
     * @see Restriction
     */
    public void addRestriction(Restriction r)
    {
	restrictions.add(r);
    }
    
    /**
     * Adds the restriction named in the string. Does nothing if no restriction
     * is found.
     * 
     * @param r
     * @see #addRestriction(Restriction)
     */
    public void addRestriction(String r)
    {
	try {
	    addRestriction(Restriction.valueOf(r.toUpperCase()));
	} catch(Exception e) {
	    e.printStackTrace();
	}
    }
    
    /**
     * Gets an array of all restrictions this item has.
     * 
     * @return an array of restrictions
     * @see Restriction
     */
    public Restriction[] getRestrictions()
    {
	return restrictions.toArray(new Restriction[restrictions.size()]);
    }
    
    @Override
    public String toString()
    {
	return "{id=" + id + "name=" + name + "type=" + type + "icon=" + icon
		+ "description=" + desc + "rarity=" + rare + "}";
    }
}
