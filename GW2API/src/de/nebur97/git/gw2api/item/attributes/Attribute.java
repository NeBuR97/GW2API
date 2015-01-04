package de.nebur97.git.gw2api.item.attributes;

/**
 * An object representing an attribute.
 * To create an attribute, use the factory method
 * {@link #createAttribute(String, int)}
 * 
 * @see AttributeType
 * @author NeBuR97
 **/
public class Attribute
{
    /**
     * Attributes. <li>ConditionDamage <li>CritDamage (= Ferocity. It's called
     * CritDamage in the API.) <li>Healing <li>Power <li>Precision <li>Toughness
     * <li>Vitality
     **/
    public enum AttributeType
    {
	/**
	 * Condition Damage
	 */
	CONDITIONDAMAGE,
	
	/**
	 * Ferocity
	 */
	CRITDAMAGE() {
	    @Override
	    public String toString()
	    {
		return "Ferocity";
	    }
	},
	
	/**
	 * Healing Power
	 */
	HEALING() {
	    @Override
	    public String toString()
	    {
		return "Healing Power";
	    }
	},
	
	/**
	 * Power
	 */
	POWER,
	
	/**
	 * Precision
	 */
	PRECISION,
	
	/**
	 * Toughness
	 */
	TOUGHNESS,
	
	/**
	 * Vitality
	 */
	VITALITY;
    }
    
    private int modifier;
    private AttributeType aT;
    
    private Attribute(AttributeType aT, int mod)
    {
	this.aT = aT;
	modifier = mod;
    }
    
    /**
     * @return The attribute's modifier.
     */
    public int getModifier()
    {
	return modifier;
    }
    
    /**
     * @return The attribute's type
     * @see AttributeType
     */
    public AttributeType getAttributeType()
    {
	return aT;
    }
    
    /**
     * Creates a new Attribute.
     * 
     * @param type
     * - This String will be used in valueOf(type) to get the AttributeType.
     * @see #createAttribute(AttributeType, int)
     */
    public static Attribute createAttribute(String type, int modifier)
    {
	try {
	    return createAttribute(AttributeType.valueOf(type), modifier);
	} catch(Exception e) {
	    return null;
	}
    }
    
    /**
     * Creates a new Attribute.<br>
     * E.g: Exotic lvl 80 boots with Berserker stats:<br>
     * <li><b><i>Attribute 1 = </i>AttributeType:</b>
     * {@link AttributeType#Power Power}, <b>modifier:</b> 34<br> <li>
     * <b><i>Attribute 2 = </i>AttributeType:</b>
     * {@link AttributeType#Precision Precision} , <b>modifier:</b> 24<br> <li>
     * <b><i>Attribute 3 = </i>AttributeType:</b>
     * {@link AttributeType#CritDamage CritDamage}, <b>modifier:</b> 24<br>
     * 
     * @param type
     * The AttributeType.
     * @see AttributeType
     * @param modifier
     * The modifier.
     */
    public static Attribute createAttribute(AttributeType type, int modifier)
    {
	return (type != null ) ? new Attribute(type, modifier) : null;
    }
}
