package de.nebur97.git.gw2api.type.weapon;

/**
 * An enum of one-handed weapons. <li>{@link Axe#} <li>{@link Dagger#} <li>
 * {@link Mace#} <li>{@link Pistol#} <li>{@link Scepter#} <li>{@link Sword#}
 * 
 * @author NeBuR97
 **/
public enum OneHanded implements WeaponType
{
    AXE, DAGGER, MACE, PISTOL, SCEPTER() {
	@Override
	public boolean canBeOffHand()
	{
	    return false;
	}
    },
    SWORD;
    
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
}