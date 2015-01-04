package de.nebur97.git.gw2api.item;

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
    
    private int	minPow;
    private int	maxPow;
    private DamageType dType;
    
    public void setType(String type)
    {
	setType(WEAPON.getWeaponType(type));
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
     * Set the minimum damage.
     * 
     * @param minPow
     * - the minimum power
     */
    public void setMinPower(int minPow)
    {
	this.minPow = minPow;
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
}
