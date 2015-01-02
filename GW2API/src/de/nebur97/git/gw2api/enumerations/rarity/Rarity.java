package de.nebur97.git.gw2api.enumerations.rarity;

import java.awt.Color;


	public enum Rarity{
		JUNK(new Color(188,170,170)),
		BASIC(new Color(0,0,0)),
		FINE(new Color(122,164,218)),
		MASTERWORK(new Color(26,147,6)),
		RARE(new Color(252,208,11)),
		EXOTIC(new Color(255,164,5)),
		ASCENDED(new Color(251,62,141)),
		LEGENDARY(new Color(76,19,157));
		private final Color col;
		
		Rarity(Color col)
		{
			this.col = col;
		}
		
		public Color color()
		{
			return col;
		}
		
		public static Rarity getRarity(String rare)
		{
			switch(rare)
			{
				case "Junk":
					return JUNK;
				case "Basic":
					return BASIC;
				case "Fine":
					return FINE;
				case "Masterwork":
					return MASTERWORK;
				case "Rare":
					return RARE;
				case "Exotic":
					return EXOTIC;
				case "Ascended":
					return ASCENDED;
				case "Legendary":
					return LEGENDARY;
			}
			return JUNK;
		}
	}
