package de.nebur97.git.gw2api.enumerations.type.weapon;

public enum WEAPON {
	//one-handed mainhand
	Axe,
	Dagger,
	Mace,
	Pistol,
	Scepter,
	Sword,
	
	//one-handed offhand
	Focus,
	Shield,
	Torch,
	Warhorn,
	
	//two-handed
	Greatsword,
	Hammer,
	LongBow,
	Rifle,
	ShortBow,
	Staff,
	
	//aquatic
	Harpoon,
	Speargun,
	Trident,
	
	//other
	LargeBundle,
	SmallBundle,
	Toy,
	TwoHandedToy;
	public static WEAPON getEnumConstant(String type)
	{
		switch(type.toLowerCase())
		{
			case "axe":
				return Axe;
			case "dagger":
				return Dagger;
			case "mace":
				return Mace;
			case "pistol":
				return Pistol;
			case "scepter":
				return Scepter;
			case "sword":
				return Sword;
			case "focus":
				return Focus;
			case "shield":
				return Shield;
			case "torch":
				return Torch;
			case "warhorn":
				return Warhorn;
			case "greatsword":
				return Greatsword;
			case "hammer":
				return Hammer;
			case "longbow":
				return LongBow;
			case "rifle":
				return Rifle;
			case "shortbow":
				return ShortBow;
			case "staff":
				return Staff;
			case "harppon":
				return Harpoon;
			case "speargun":
				return Speargun;
			case "trident":
				return Trident;
			case "largebundle":
				return LargeBundle;
			case "smallbundle":
				return SmallBundle;
			case "toy":
				return Toy;
			case "twohandedtoy":
				return TwoHandedToy;
		}
		return null;
	}
	
	public boolean isAquatic()
	{
		String name = this.name().toLowerCase();
		return name.equals("harpoon")
			|| name.equals("speargun")
			|| name.equals("trident");
	}
	
	public boolean isTwoHanded()
	{
		String name = this.name().toLowerCase();
		return name.equals("greatsword")
			|| name.equals("hammer")
			|| name.equals("longbow")
			|| name.equals("rifle")
			|| name.equals("shortbow")
			|| name.equals("staff");
	}
	
	public boolean isOther()
	{
		String name = this.name().toLowerCase();
		return name.equals("largebundle")
			|| name.equals("smallbundle")
			|| name.equals("toy");
	}
	public boolean isOneHanded()
	{
		return !isAquatic() && !isTwoHanded() && !isOther();
	}
}
