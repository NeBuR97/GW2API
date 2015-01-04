package de.nebur97.git.gw2api.type.weapon;

/**
 * An enum of offhand weapons. <li>{@link #Focus} <li>{@link #Shield} <li>
 * {@link #Torch} <li>{@link #Warhorn}
 * 
 * @author NeBuR97
 **/
public enum OffHand implements WeaponType
{
    FOCUS, SHIELD, TORCH, WARHORN;
    
    @Override
    public boolean isAquatic()
    {
	return false;
    }
    
    @Override
    public boolean isOffHand()
    {
	return true;
    }
    
    @Override
    public boolean isOneHanded()
    {
	return true;
    }
    
    @Override
    public boolean isOther()
    {
	return false;
    }
    
    @Override
    public boolean isTwoHanded()
    {
	return false;
    }
    
    @Override
    public boolean canBeOffHand()
    {
	return true;
    }

    @Override
    public WEAPON getCategory()
    {
	return WEAPON.OFFHAND;
    }
}