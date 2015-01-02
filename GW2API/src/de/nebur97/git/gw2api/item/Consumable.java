package de.nebur97.git.gw2api.item;

import de.nebur97.git.gw2api.enumerations.type.consumable.CONSUMABLE;

public class Consumable extends Item {
	private CONSUMABLE type;
	private long durMS;
	public enum UnlockType{
		BagSlot,
		BankTab,
		
	}
}
