package de.nebur97.git.gw2api.type.armor;

public enum ARMOR{
	Boots,
	Coat,
	Gloves,
	Helm,
	HelmAquatic,
	Leggings,
	Shoulders;
	public enum WeightClass{
		HEAVY,
		MEDIUM,
		LIGHT,
		CLOTHING;
	}
	/**
	 * Returns the corresponding ARMOR constant.
	 * @param type
	 * @return ARMOR
	 **/
	public static ARMOR getARMOR(String type)
	{
		switch(type.toLowerCase())
		{
			case "boots":
				return Boots;
			case "coat":
				return Coat;
			case "gloves":
				return Gloves;
			case "helm":
				return Helm;
			case "helmaquatic":
				return HelmAquatic;
			case "leggings":
				return Leggings;
			case "shoulders":
				return Shoulders;
		}
		return null;
	}
	
	/**
	 * Returns the corresponding WeightClass constant.
	 * @param type
	 * @return WeightClass
	 **/
	public static WeightClass getWeightClass(String s)
	{
		switch(s.toLowerCase())
		{
			case "heavy":
				return WeightClass.HEAVY;
			case "medium":
				return WeightClass.MEDIUM;
			case "light":
				return WeightClass.LIGHT;
			case "clothing":
				return WeightClass.CLOTHING;
		}
		return null;
	}
}
