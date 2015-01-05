package de.nebur97.git.gw2api.item;

import java.util.ArrayList;
import java.util.List;

import de.nebur97.git.gw2api.item.infusions.Infusion;
import de.nebur97.git.gw2api.type.Type;
import de.nebur97.git.gw2api.type.upgradecomponent.UpgradeCompFlag;
import de.nebur97.git.gw2api.type.upgradecomponent.UpgradeCompType;

public class UpgradeComponent extends Item
{
    private List<UpgradeCompFlag> flags = new ArrayList<UpgradeCompFlag>();
    private String suffix;
    private Infusion applicableInfusion;
    
    
    public UpgradeComponent(Item parent)
    {
	super(parent);
	setItemType(Type.UPGRADECOMPONENT);
    }

    
    /**
     * Set the upgrade'S type.
     * 
     * @param t
     */
    public void setType(String t)
    {
	try{
	    setType(UpgradeCompType.valueOf(t.toUpperCase()));
	}catch(Exception e)
	{
	    e.printStackTrace();
	}
    }
    
    /**
     * Get the name suffix.
     * 
     * @return name suffix
     */
    public String getSuffix()
    {
	return suffix;
    }
    
    /**
     * Set the name suffix.
     * 
     * @param suffix
     */
    public void setSuffix(String suffix)
    {
	this.suffix = suffix;
    }
    
    /**
     * Get the applicable infusion.
     * 
     * @return infusion
     */
    public Infusion getApplicableInfusion()
    {
	return applicableInfusion;
    }
    
    /**
     * Set the applicable infusion.
     * 
     * @param applicableInfusion
     */
    public void setApplicableInfusion(Infusion applicableInfusion)
    {
	this.applicableInfusion = applicableInfusion;
    }
    
    /**
     * @see #setApplicableInfusion(Infusion)
     * @param inf
     */
    public void setApplicableInfusion(String inf)
    {
	try {
	    setApplicableInfusion(Infusion.valueOf(inf.toUpperCase()));
	} catch(Exception e) {
	    e.printStackTrace();
	    setApplicableInfusion(Infusion.NONE);
	}
    }
    
    /**
     * Add a flag.
     * 
     * @param f
     * @see UpgradeCompFlag
     */
    public void addUpgradeFlag(UpgradeCompFlag f)
    {
	flags.add(f);
    }
    
    /**
     * @see #addUpgradeFlag(UpgradeCompFlag)
     */
    public void addUpgradeFlag(String s)
    {
	addUpgradeFlag(UpgradeCompFlag.valueOf(s.toUpperCase()));
    }
    
    /**
     * Get all upgrade flags
     * 
     * @return an array of upgrade flags.
     */
    public UpgradeCompFlag[] getUpgradeFlags()
    {
	return flags.toArray(new UpgradeCompFlag[flags.size()]);
    }
}
