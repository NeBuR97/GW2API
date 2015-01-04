package de.nebur97.git.gw2api.type.weapon;

/**
 * An enum of aquatic weapons.<br>
 * Contains:<br>
 * <li>{@link #Harpoon}<br> <li>{@link #Speargun}<br> <li>{@link #Trident}<br>
 * 
 * @author NeBuR97
 **/
public enum Aquatic implements WeaponType
{
    HARPOON, SPEARGUN, TRIDENT;

    @Override
    public boolean isAquatic()
    {
	return true;
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
}