package de.nebur97.git.gw2api.type.consumable;

/**
 * Possible unlock types of consumables. <li>{@link #BAGSLOT} <li>
 * {@link #BANKTAB} <li>{@link #COLLECTIBLECAPACITY} <li>{@link #CONTENT} <li>
 * {@link #CRAFTINGRECIPE} <li>{@link #DYE} <li>{@link #UNKNOWN} <li>
 * {@link #NONE}
 * 
 * @author NeBuR97
 * 
 */
public enum UnlockType
{
    /** For Bag Slot Expansion **/
    BAGSLOT,
    
    /** For Bank Slot Expansion **/
    BANKTAB,
    
    /** For Storage Expander **/
    COLLECTIBLECAPACITY,
    
    /** Finishers and Collection unlocks, and Commander's Compendium **/
    CONTENT,
    
    /** Crafting recipes **/
    CRAFTINGRECIPE,
    
    /** Dyes **/
    DYE,
    
    /** If no type is specified **/
    NONE,
    
    /** Outfits **/
    UNKNOWN;
}