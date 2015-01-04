package de.nebur97.git.gw2api.item;

import de.nebur97.git.gw2api.type.gizmo.GizmoType;

/**
 * A Gizmo item.
 * 
 * @author NeBuR97
 * 
 */
public class Gizmo extends Item
{
    private GizmoType type;
    
    @Override
    public GizmoType getType()
    {
	return type;
    }
    
    /**
     * @see #setType(String)
     * @param gt
     */
    public void setType(String s)
    {
	setType(GizmoType.valueOf(s.toUpperCase()));
    }
    
}
