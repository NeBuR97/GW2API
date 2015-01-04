package de.nebur97.git.gw2api.item.infusions;

/**
 * Implemented by items with an infusion slot, such as armor.
 * @author NeBuR
 *
 */
public interface Infusable
{
    /**
     * Set the item's infusion slot.
     * @param inf
     * @see Infusion
     */
    public void setInfusionSlot(Infusion inf);
    
    public void setInfusionSlot(String inf);
    /**
     * Get the item's infusion slot.
     * @return The infusion slot
     * @see Infusion
     */
    public Infusion getInfusionSlot();
}
