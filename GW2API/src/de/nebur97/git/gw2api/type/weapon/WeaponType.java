package de.nebur97.git.gw2api.type.weapon;

public interface WeaponType
{
    public boolean canBeOffHand();
    
    /**
     * 
     * @return a {@link WEAPON} constant.
     */
    public WEAPON getCategory();
    
    public boolean isAquatic();
    
    public boolean isOffHand();
    
    public boolean isOneHanded();
    
    public boolean isOther();
    
    public boolean isTwoHanded();
}
