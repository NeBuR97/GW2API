package de.nebur97.git.gw2api.type.gizmo;

/**
 * Possible Gizmo types.
 * 
 * @author NeBuR97
 * 
 */
public enum GizmoType
{
    DEFAULT,
    
    /**
     * For Black Lion Chest Keys.
     */
    CONJTAINER_KEY,
    
    /**
     * For time-limited NPC services (e.g. Golem Banker, Personal Merchant
     * Express)
     */
    RENTABLE_CONTRACT_NPC,
    
    /**
     * For Permanent Self-Style Hair Kit
     */
    UNLIMITED_CONSUMABLE;
}
