package de.nebur97.git.gw2api.item;

import de.nebur97.git.gw2api.enumerations.type.weapon.DAMAGETYPE;
import de.nebur97.git.gw2api.enumerations.type.weapon.WEAPON;

public class Weapon extends Item {

	private WEAPON type;
	private int minPow;
	private int maxPow;
	private DAMAGETYPE dType;
	
	@Override
	public WEAPON getType() {
		return type;
	}
	@Override
	public void setType(String type) {
		this.type = WEAPON.valueOf(type);
	}
	public int getMinPow() {
		return minPow;
	}
	public void setMinPow(int minPow) {
		this.minPow = minPow;
	}
	public int getMaxPow() {
		return maxPow;
	}
	public void setMaxPow(int maxPow) {
		this.maxPow = maxPow;
	}
	public DAMAGETYPE getDamageType() {
		return dType;
	}
	public void setDamageType(DAMAGETYPE dType) {
		this.dType = dType;
	}
}
