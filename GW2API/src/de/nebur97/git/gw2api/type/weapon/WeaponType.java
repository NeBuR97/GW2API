package de.nebur97.git.gw2api.type.weapon;

public interface WeaponType
{
    public boolean isAquatic();
    
    public boolean isOffHand();
    
    public boolean isOneHanded();
    
    public boolean isOther();
    
    public boolean isTwoHanded();
    
    public boolean canBeOffHand();
}
