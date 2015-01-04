package de.nebur97.git.gw2api.type.consumable;

/**
 * Consumables.<br>
 * Contains:<br>
 * <li>{@link #AppearenceChange} <li>{@link #Booze} <li>{@link #ContractNpc} <li>
 * {@link #Food} <li>{@link #Generic} <li>{@link #Halloween} <li>
 * {@link #Immediate} <li>{@link #Transmutation} <li>{@link #Unlock} <li>
 * {@link #UpgradeRemoval} <li>{@link #Utility}
 * 
 * @author NeBuR97
 **/
public enum ConsumableType
{
    /** For Total Makeover Kits, Self-Style Hair Kits, and Name Change Contracts **/
    APPEARENCECHANGE,
    
    /** Alcohol consumables **/
    BOOZE,
    
    /** For Trading Post Express, Merchant Express, Golem Banker **/
    CONTRACTNPC,
    
    /** Food consumables **/
    FOOD,
    
    /** Various consumables **/
    GENERIC,
    
    /** Some boosters **/
    HALLOWEEN,
    
    /**
     * Consumables granting immediate effect (most boosters, Heavy Tome of
     * Knowledge)
     **/
    IMMEDIATE,
    
    /** Skin consumables **/
    TRANSMUTATION,
    
    /** Unlock consumables **/
    UNLOCK,
    
    /** For Upgrade Extractor **/
    UPGRADEREMOVAL,
    
    /** Utility boosts (Potions etc.) **/
    UTILITY;
}
