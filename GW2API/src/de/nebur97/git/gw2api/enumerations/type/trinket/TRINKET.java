package de.nebur97.git.gw2api.enumerations.type.trinket;

public enum TRINKET {
	Accessory,
	Amulet,
	Ring;
	
	public static TRINKET getEnumConstant(String t)
	{
		switch(t.toLowerCase())
		{
			case "accessory":
				return Accessory;
			case "amulet":
				return Amulet;
			case "ring":
				return Ring;
		}
		return null;
	}
}
