package de.nebur97.git.gw2api.item;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import de.nebur97.git.gw2api.item.flags.Flag;
import de.nebur97.git.gw2api.item.gametypes.GameType;
import de.nebur97.git.gw2api.item.restrictions.Restriction;
import de.nebur97.git.gw2api.manager.EntryWithID;
import de.nebur97.git.gw2api.rarity.Rarity;
import de.nebur97.git.gw2api.tradingpost.TPEntry;
import de.nebur97.git.gw2api.type.Type;

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
public class Item implements EntryWithID, Serializable
{
    /**
	 * eclipse wanted me to, I have no clue what this means tbh.
	 */
	private static final long serialVersionUID = 8986220910498373063L;
	//not to be confused with type! This is for identification purposes only.
    private Type itemType;
    private int id;
    private String name;
    private Object type = "No type specified";
    private URL icon;
    private String desc;
    private Rarity rare;
    private int level;
    private int vendorValue;
    private List<GameType> gameTypes = new ArrayList<GameType>();
    private List<Flag> flags = new ArrayList<Flag>();
    private List<Restriction> restrictions = new ArrayList<Restriction>();
    private TPEntry tpEntry;
    
    public Item(Item parent)
    {
	id = parent.id;
	name = parent.name;
	type = parent.type;
	icon = parent.icon;
	desc = parent.desc;
	rare = parent.rare;
	level = parent.level;
	vendorValue = parent.vendorValue;
	gameTypes = parent.gameTypes;
	flags = parent.flags;
	restrictions = parent.restrictions;
    }
    public Item()
    {
    }
    /**
     * Gets the item's id.
     * 
     * @return id
     */
    @Override
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
    public ArrayList<GameType> getGameTypes()
    {
    	return new ArrayList<GameType>(gameTypes);
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
    public ArrayList<Flag> getFlags()
    {
    	if(flags.isEmpty())
    	{
    		flags.add(Flag.NONE);
    	}
    	return new ArrayList<Flag>(flags);
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
    public ArrayList<Restriction> getRestrictions()
    {
    	if(restrictions.isEmpty())
    	{
    		restrictions.add(Restriction.NONE);
    	}
    	return new ArrayList<Restriction>(restrictions);
    }
    
    @Override
    public String toString()
    {
	StringBuilder b = new StringBuilder();
	b.append("{");
	for(Method m : this.getClass().getMethods())
	{
	    if(m.getName().contains("get"))
	    {
		try {
		    Object val = m.invoke(this);
		    if(val instanceof List)
		    {
			b.append(m.getName().replace("get", "")+"{");
			for(Object o : (List)val)
			{
			    b.append(o+",");
			}
			b.append("}\n");
		    } else if(val != null && !m.getName().contains("Class"))
		    {
			b.append(m.getName().replace("get", "") + ":" + m.invoke(this)+"\n");
		    }
                }
                catch(IllegalAccessException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
                }
                catch(IllegalArgumentException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
                }
                catch(InvocationTargetException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
                }
	    }
	}
	b.append("}");
	return b.toString();
    }
    
    /**
     * Possible properties:
     * <li>name
     * <li>type
     * <li>level
     * <li>rarity
     * <li>vendor_value
     * <li>default_skin<i>(not implemented)</i>
     * <li>game_types
     * <li>flags
     * <li>restrictions
     * <li>id
     * <li>icon
     * @param prop
     * @param value
     */
    public void setProperty(String prop, Object value)
    {
	switch(prop)
	{
	case "name":
	    name = value.toString();
	    break;
	case "description":
	    desc = value.toString();
	    break;
	case "type":
	    setType(value.toString());
	    break;
	case "level":
	    level = (Integer)value;
	    break;
	case "rarity":
	    rare = Rarity.valueOf(value.toString().toUpperCase());
	    break;
	case "vendor_value":
	    vendorValue = (Integer)value;
	    break;
	case "game_types":
	    addGameType(value.toString());
	    break;
	case "flags":
	    addFlag(value.toString());
	    break;
	case "restrictions":
	    addRestriction(value.toString());
	    break;
	case "id":
	    id = (Integer)value;
	    break;
	case "icon":
	    try {
	        icon = new URL(value.toString());
            }
            catch(MalformedURLException e) {
	        e.printStackTrace();
            }
	    break;
	}
    }
    
    public Item createSubItem(String type)
    {
	switch(type)
	{
	case "Armor":
	    return new Armor(this);
	case "Back":
	    return new Back(this);
	case "Bag":
	    return new Bag(this);
	case "Consumable":
	    return new Consumable(this);
	case "CraftingMaterial":
	    return new CraftingMaterial(this);
	case "Gathering":
	    return new Gathering(this);
	case "Gizmo":
	    return new Gizmo(this);
	case "MiniPet":
	    return new MiniPet(this);
	case "Tool":
	    return new Tool(this);
	case "Trait":
	    return new Trait(this);
	case "Trinket":
	    return new Trinket(this);
	case "Trophy":
	    return new Trophy(this);
	case "UpgradeComponent":
	    return new UpgradeComponent(this);
	case "Weapon":
	    return new Weapon(this);
	}
	return this;
    }
    
    public Type getItemType()
    {
        return itemType;
    }
    
    protected void setItemType(Type itemType)
    {
        this.itemType = itemType;
    }
	public TPEntry getTradingPostEntry() {
		return tpEntry;
	}
	public void setTradingPostEntry(TPEntry tpEntry) {
		this.tpEntry = tpEntry;
	}

	public boolean hasFlag(Flag f)
	{
		return flags.contains(f);
	}
	
	public boolean hasRestriction(Restriction r)
	{
		return restrictions.contains(r);
	}
	
	public boolean isGameType(GameType g)
	{
		return gameTypes.contains(g);
	}

}
