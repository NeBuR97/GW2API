package de.nebur97.git.gw2api.item;

import java.net.URL;

public interface Item {
	public int getID();
	@Override
	public String toString();
	public String getName();
	public Enum getType();
	public URL getIcon();
}
