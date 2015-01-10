package de.nebur97.git.gw2api.item;

import de.nebur97.git.gw2api.type.Type;
import de.nebur97.git.gw2api.type.weapon.DamageType;
import de.nebur97.git.gw2api.type.weapon.WEAPON;

/**
 * An object representing a weapon.<br>
 * For possible types of weapons, see <li>
 * {@link de.nebur97.git.gw2api.type.weapon.Aquatic Aquatic} <li>
 * {@link de.nebur97.git.gw2api.type.weapon.OffHand OffHand} <li>
 * {@link de.nebur97.git.gw2api.type.weapon.OneHanded OneHanded} <li>
 * {@link de.nebur97.git.gw2api.type.weapon.Other Other} <li>
 * {@link de.nebur97.git.gw2api.type.weapon.TwoHanded TwoHanded}
 * 
 * @author NeBuR97
 * 
 */
public class Weapon extends Gear
{
    private static final long serialVersionUID = 1100001169029261102L;
    
    private DamageType dType;
    
    private int maxPow;
    private int minPow;
    
    public Weapon(Item parent)
    {
	super(parent);
	setItemType(Type.WEAPON);
    }
    
    /**
     * Get the damage type.
     * 
     * @return damagetype
     * @see de.nebur97.git.gw2api.type.weapon.DamageType DamageType
     */
    public DamageType getDamageType()
    {
	return dType;
    }
    
    /**
     * Get the maximum damage.
     * 
     * @return maximum damage
     */
    public int getMaxPower()
    {
	return maxPow;
    }
    
    /**
     * Get the weapons minimum damage.
     * 
     * @return minimum weapon power
     */
    public int getMinPower()
    {
	return minPow;
    }
    
    /**
     * Set the damage type.
     * 
     * @param dType
     * - the damage type
     * @see de.nebur97.git.gw2api.type.weapon.DamageType DamageType
     */
    public void setDamageType(DamageType dType)
    {
	this.dType = dType;
    }
    
    public void setDamageType(String dType)
    {
	setDamageType(DamageType.valueOf(dType.toUpperCase()));
    }
    
    /**
     * Set the maximum damage.
     * 
     * @param maxPow
     * - maximum power
     */
    public void setMaxPower(int maxPow)
    {
	this.maxPow = maxPow;
    }
    
    /**
     * Set the minimum damage.
     * 
     * @param minPow
     * - the minimum power
     */
    public void setMinPower(int minPow)
    {
	this.minPow = minPow;
    }
    
    @Override
    public void setProperty(String prop, Object value)
    {
	switch(prop)
	{
	    case "damage_type":
		setDamageType(value.toString());
		break;
	    case "min_power":
		minPow = (Integer) value;
		break;
	    case "max_power":
		maxPow = (Integer) value;
		break;
	    default:
		super.setProperty(prop, value);
	}
    }
    
    public void setType(String type)
    {
	try {
	    setType(WEAPON.getWeaponType(type));
	}
	catch(Exception e) {
	    e.printStackTrace();
	}
    }
}
