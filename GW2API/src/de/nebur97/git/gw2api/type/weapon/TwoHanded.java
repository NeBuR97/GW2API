package de.nebur97.git.gw2api.type.weapon;

/**
 * An enum of two-handed weapons. <li>{@link #Greatsword} <li>{@link #Hammer}
 * <li>{@link #LongBow} <li>{@link #Rifle} <li>{@link #Rifle} <li>
 * {@link #ShortBow} <li>{@link #Staff}
 * 
 * @author NeBuR97
 **/
public enum TwoHanded implements WeaponType
{
    GREATSWORD, HAMMER, LONGBOW, RIFLE, SHORTBOW, STAFF;
    
    @Override
    public boolean isAquatic()
    {
	return false;
    }
    
    @Override
    public boolean isOffHand()
    {
	return false;
    }
    
    @Override
    public boolean isOneHanded()
    {
	return false;
    }
    
    @Override
    public boolean isOther()
    {
	return false;
    }
    
    @Override
    public boolean isTwoHanded()
    {
	return true;
    }
    
    @Override
    public boolean canBeOffHand()
    {
	return false;
    }

    @Override
    public WEAPON getCategory()
    {
	return WEAPON.TWOHANDED;
    }
}