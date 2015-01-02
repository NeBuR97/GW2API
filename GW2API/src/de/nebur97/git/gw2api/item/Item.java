package de.nebur97.git.gw2api.item;

import java.net.URL;

import de.nebur97.git.gw2api.enumerations.rarity.Rarity;

public class Item {
	private int id;
	private String name;
	private Enum<?> type;
	private URL icon;
	private String desc;
	private Rarity rare;
	
	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Enum<?> getType() {
		return type;
	}
	public void setType(String type) {
	}
	public URL getIcon() {
		return icon;
	}
	public void setIcon(URL icon) {
		this.icon = icon;
	}
	public String getDescription() {
		return desc;
	}
	public void setDescription(String desc) {
		this.desc = desc;
	}
	public Rarity getRarity() {
		return rare;
	}
	public void setRarity(Rarity rare) {
		this.rare = rare;
	}
	@Override
	public String toString()
	{
		return "{id="+id+"name="+name+"type="+type+"icon="+icon+"description="+desc+"rarity="+rare+"}";
	}
}
