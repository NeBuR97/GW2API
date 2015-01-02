package de.nebur97.git.gw2api.enumerations.type;

public enum GearType {
	ARMOR,
	BACK,
	BAG,
	CONSUMABLE,
	CONTAINER,
	CRAFTINGMATERIAL,
	GATHERING,
	GIZMO,
	MINIPET,
	TOOL,
	TRAIT,
	TRINKET,
	TROPHY,
	UPGRADECOMPONENT,
	WEAPON;
	
	public static GearType getGearType(String type)
	{
		switch(type.toLowerCase())
		{
			case "armor":
				return ARMOR;
			case "back":
				return BACK;
			case "bag":
				return BAG;
			case "consumable":
				return CONSUMABLE;
			case "container":
				return CONTAINER;
			case "craftingmaterial":
				return CRAFTINGMATERIAL;
			case "gathering":
				return GATHERING;
			case "gizmo":
				return GIZMO;
			case "minipet":
				return MINIPET;
			case "tool":
				return TOOL;
			case "trait":
				return TRAIT;
			case "trinket":
				return TRINKET;
			case "trophy":
				return TROPHY;
			case "upgradecomponent":
				return UPGRADECOMPONENT;
			case "weapon":
				return WEAPON;
		}
		return null;
	}
}

