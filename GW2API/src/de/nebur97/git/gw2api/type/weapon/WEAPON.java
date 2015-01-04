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
     * Will only be returned when no other type could be found
     */

    public static WeaponType getWeaponType(String type)
    {
	WeaponType wType = Other.UNKNOWN;
	// check if type is mentioned in Aquatic
	try {
	    wType = Aquatic.valueOf(type);
	} catch(Exception e) {/* Type is not aquatic */
	}

	// offhand
	try {
	    wType = OffHand.valueOf(type);
	} catch(Exception e) {/* Type is not an offhand */
	}

	// one-handed
	try {
	    wType = OneHanded.valueOf(type);
	} catch(Exception e) {/* Type is not one-handed */
	}

	// other
	try {
	    wType = Other.valueOf(type);
	} catch(Exception e) {/* Type is not in other */
	}

	// Twohanded
	try {
	    wType = TwoHanded.valueOf(type);
	} catch(Exception e) {/* Type is not two-handed */
	}
	return wType;
    }
}
