package de.nebur97.git.gw2api.item.infusions;

import java.util.ArrayList;
import java.util.List;

/**
 * Implemented by items with an infusion slot, such as armor.
 * 
 * @author NeBuR
 * 
 */
public interface Infusable
{
    /**
     * Set the item's infusion slot.
     * 
     * @param inf
     * @see Infusion
     */
    public void addInfusionSlot(Infusion inf);
    
    public void addInfusionSlot(String inf);
    
    /**
     * Get the item's infusion slot.
     * 
     * @return The infusion slot
     * @see Infusion
     */
    public List<Infusion> getInfusionSlots();
}
