package de.nebur97.git.gw2api.item.flags;

/**
 * All possible flags an item can have. <li>{@link #ACCOUNT_BIND_ON_USE} <li>
 * {@link #ACCOUNT_BOUND} <li>{@link #HIDE_SUFFIX} <li>{@link #MONSTER_ONLY} <li>
 * {@link #NO_MYSTIC_FORGE} <li>{@link #NO_SALVAGE} <li>{@link #NO_SELL} <li>
 * {@link #NOT_UPGRADABLE} <li>{@link #NO_UNDERWATER} <li>
 * {@link #SOUL_BIND_ON_ACQUIRE} <li>{@link #SOUL_BIND_ON_USE}
 * 
 * @author NeBuR97
 * 
 */
public enum Flag
{
    /**
     * Account bound on use.
     */
    ACCOUNTBINDONUSE,
    
    /**
     * Account bound on acquire.
     */
    ACCOUNTBOUND,
    
    /**
     * Hide the suffix of the upgrade component.
     */
    HIDESUFFIX,
    
    /**
     * <i>No wiki information on this one.</i>
     */
    MONSTERONLY,
    
    /**
     * Not usable in the Mystic Forge.
     */
    NOMYSTICFORGE,
    
    /**
     * Not salvageable.
     */
    NOSALVAGE,
    
    /**
     * Not sellable.
     */
    NOSELL,
    
    /**
     * Not upgradeable.
     */
    NOTUPGRADEABLE,
    
    /**
     * Not available underwater.
     */
    NOUNDERWATER,
    
    /**
     * Soulbound on acquire.
     */
    SOULBINDONACQUIRE,
    
    /**
     * Soulbound on use.
     */
    SOULBINDONUSE,
    
    /**
     * Unique.
     */
    UNIQUE;
}
