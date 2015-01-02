package de.nebur97.git.gw2api.enumerations.type.consumable;

public enum CONSUMABLE {
	AppearencChange,
	Booze,
	ContractNpc,
	Food,
	Generic,
	Halloween,
	Immediate,
	Transmutation,
	Unlock,
	UpgradeRemoval,
	Utility;
	
	public static CONSUMABLE getEnumConstant(String c)
	{
		switch(c.toLowerCase())
		{
		case "appearencechange":
			return AppearencChange;
		case "booze":
			return Booze;
		case "contractnpc":
			return ContractNpc;
		case "food":
			return Food;
		case "generic":
			return Generic;
		case "halloween":
			return Halloween;
		case "immediate":
			return Immediate;
		case "transmutation":
			return Transmutation;
		case "unlock":
			return Unlock;
		case "upgraderemovla":
			return UpgradeRemoval;
		case "utility":
			return Utility;
		}
		return null;
	}
}
