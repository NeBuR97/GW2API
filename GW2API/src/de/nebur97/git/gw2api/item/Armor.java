package de.nebur97.git.gw2api.item;

import java.net.URL;

import de.nebur97.git.gw2api.type.armor.ARMOR;

public class Armor implements Item {

	private int id;
	private ARMOR type;
	private int def;
	
	@Override
	public int getID() {
		return 0;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public ARMOR getType() {
		return null;
	}

	@Override
	public URL getIcon() {
		return null;
	}

}
