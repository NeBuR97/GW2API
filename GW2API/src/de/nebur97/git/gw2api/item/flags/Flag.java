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
    ACCOUNT_BIND_ON_USE,
    
    /**
     * Account bound on acquire.
     */
    ACCOUNT_BOUND,
    
    /**
     * Hide the suffix of the upgrade component.
     */
    HIDE_SUFFIX,
    
    /**
     * <i>No wiki information on this one.</i>
     */
    MONSTER_ONLY,
    
    /**
     * Not usable in the Mystic Forge.
     */
    NO_MYSTIC_FORGE,
    
    /**
     * Not salvageable.
     */
    NO_SALVAGE,
    
    /**
     * Not sellable.
     */
    NO_SELL,
    
    /**
     * Not upgradeable.
     */
    NOT_UPGRADABLE,
    
    /**
     * Not available underwater.
     */
    NO_UNDERWATER,
    
    /**
     * Soulbound on acquire.
     */
    SOUL_BIND_ON_ACQUIRE,
    
    /**
     * Soulbound on use.
     */
    SOUL_BIND_ON_USE,
    
    /**
     * Unique.
     */
    UNIQUE;
}
