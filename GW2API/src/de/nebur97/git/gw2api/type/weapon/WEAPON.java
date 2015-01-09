package de.nebur97.git.gw2api.type.weapon;

/**
 * Weapon types.<br>
 * Contains:<br>
 * <li>{@link Aquatic} <li>{@link DamageType} <li>{@link OffHand} <li>
 * {@link OneHanded} <li>{@link Other} <li>{@link TwoHanded}
 * 
 * @author NeBuR97
 **/
public enum WEAPON
{
    
    /**
     * {@link Aquatic}
     */
    AQUATIC,
    
    /**
     * {@link DamageType}
     */
    DAMAGETYPE,
    
    /**
     * {@link OffHand}
     */
    OFFHAND,
    
    /**
     * {@link OneHanded}
     */
    ONEHANDED,
    
    /**
     * {@link Other}
     */
    OTHER,
    
    /**
     * {@link TwoHanded}
     */
    TWOHANDED;
    
    /**
     * Returns the specified WeaponType. Throws an excpetion if no type can be found.
     * @throws IllegalArgumentException
     * @param type
     * @return a WeaponType
     */
    public static WeaponType getWeaponType(String t) throws IllegalArgumentException
    {
	String type = t.toUpperCase();
	// check if type is mentioned in Aquatic
	try {
	    return Aquatic.valueOf(type);
	}
	catch(Exception e) {/* Type is not aquatic */
	}
	
	// offhand
	try {
	    return OffHand.valueOf(type);
	}
	catch(Exception e) {/* Type is not an offhand */
	}
	
	// one-handed
	try {
	    return OneHanded.valueOf(type);
	}
	catch(Exception e) {/* Type is not one-handed */
	}
	
	// other
	try {
	    return Other.valueOf(type);
	}
	catch(Exception e) {/* Type is not in other */
	}
	
	// Twohanded
	try {
	    return TwoHanded.valueOf(type);
	}
<<<<<<< HEAD
	catch(Exception e) {/* Type is not two-handed */
	}
	throw new IllegalArgumentException(type + " is not a valid WeaponType!");
=======
	throw new IllegalArgumentException(type+" is not a valid WeaponType!");
>>>>>>> origin/master
    }
}
