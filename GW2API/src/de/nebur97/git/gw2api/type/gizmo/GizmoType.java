package de.nebur97.git.gw2api.type.gizmo;

/**
 * Possible Gizmo types.
 * 
 * @author NeBuR97
 * 
 */
public enum GizmoType
{
    /**
     * For Black Lion Chest Keys.
     */
    CONTAINERKEY,
    
    DEFAULT,
    
    /**
     * For time-limited NPC services (e.g. Golem Banker, Personal Merchant
     * Express)
     */
    RENTABLECONTRACTNPC,
    
    /**
     * For Permanent Self-Style Hair Kit
     */
    UNLIMITEDCONSUMABLE;
}
