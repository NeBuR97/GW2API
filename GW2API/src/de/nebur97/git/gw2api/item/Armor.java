package de.nebur97.git.gw2api.item;

import de.nebur97.git.gw2api.enumerations.type.armor.ARMOR;
import de.nebur97.git.gw2api.enumerations.type.armor.ARMOR.WeightClass;

public class Armor extends Item {

	private ARMOR type;
	private int def;
	private WeightClass wClass;
	public int getDefense()
	{
		return def;
	}
	
	@Override
	public void setType(String type)
	{
		this.type = ARMOR.valueOf(type);
	}
	@Override
	public ARMOR getType()
	{
		return type;
	}
	public WeightClass getWeightClass()
	{
		return wClass;
	}
	public void setDefense(int def) {
		this.def = def;
	}
	public void setWeightClass(String wClass) {
		this.wClass = ARMOR.WeightClass.valueOf(wClass);
	}
}
