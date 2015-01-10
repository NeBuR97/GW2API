package de.nebur97.git.gw2api.tradingpost;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import de.nebur97.git.gw2api.GW2API;
import de.nebur97.git.gw2api.item.Item;
import de.nebur97.git.gw2api.manager.item.ItemManager;

public class TradingPost implements Iterable<TPEntry>, Serializable
{
    static final long serialVersionUID = -3639157505106711422L;
    private transient ItemManager iMan;
    private HashMap<Integer, TPEntry> loaded = new HashMap<Integer, TPEntry>();
    private transient HashMap<Integer, TPEntry> refresh = new HashMap<Integer, TPEntry>();
    private transient boolean refreshing = false;
    protected transient boolean loading = false;
    
    public TradingPost(GW2API api)
    {
	iMan = api.getItemManager();
    }
    
    /**
     * Convert a copper value to a String containing gold, silver and copper value.<br>
     * E.g: 12453 copper -> 1 g 24 s 53 c
     * @param copper
     * @return the copper value in g,s and c
     */
    public static String copperValueToGW2StandardCurrencyString(int copper)
    {
	String line = "" + copper;
	int l = line.length();
	if(l <= 2) {
	    return line + " c";
	} else if(l <= 4) {
	    return line.substring(0, l == 3 ? 1 : 2) + " s " + line.substring(l - 2, l);
	} else {
	    return line.substring(0, l - 4) + " g " + line.substring(l - 4, l - 2) + " s " + line.substring(l - 2) + " c";
	}
    }
    
    /**
     * Add an entry
     * @param entry
     */
    public synchronized void add(TPEntry entry)
    {
	if(refreshing) {
	    refresh.put(entry.getID(), entry);
	    Item i = iMan.get(entry.getID());
	    i.setTradingPostEntry(entry);
	    entry.setItem(i);
	} else {
	    loaded.put(entry.getID(), entry);
	    Item i = iMan.get(entry.getID());
	    i.setTradingPostEntry(entry);
	    entry.setItem(i);
	}
    }
    
    /**
     * Gets an entry via id.
     * @param id
     * @return the entry corresponding to the id
     */
    public TPEntry getEntry(int id)
    {
	return loaded.get(id);
    }
    
    /**
     * Get the associated ItemManager
     * @return s.a.
     */
    public ItemManager getItemManager()
    {
	return iMan;
    }
    
    /**
     * check if an item is loaded
     * @param id
     * @return isLoaded
     */
    public boolean isLoaded(int id)
    {
	return loaded.containsKey(id);
    }
    
    /**
     * Check if the TP is loading prices atm.
     * @return isLoading
     */
    public synchronized boolean isLoading()
    {
	return loading;
    }
    
    @Override
    public Iterator<TPEntry> iterator()
    {
	return loaded.values().iterator();
    }
    
    /**
     * Load the ids entries
     * @param ids
     */
    public void loadEntries(Collection<Integer> ids)
    {
	if( !isLoading()) {
	    setLoading(true);
	    new TPCrawler(this, ids).start();
	}
    }
    
    /**
     * Load the items' prices
     * @param items
     */
    public void loadItemEntries(Collection<Item> items)
    {
	List<Integer> ids = new ArrayList<Integer>();
	
	for(Item i : items) {
	    ids.add(i.getID());
	}
	loadEntries(ids);
    }
    
    /**
     * Refresh the entries.
     */
    public void refresh()
    {
	refreshing = true;
	loadEntries(loaded.keySet());
    }
    
    /**
     * Set the ItemManager to synchronized the prices with.
     * @param iMan
     */
    public void setItemManager(ItemManager iMan)
    {
	this.iMan = iMan;
    }
    
    protected void setLoading(boolean loading)
    {
	if(loading == false && refreshing) {
	    refreshing = false;
	    loaded = refresh;
	    refresh.clear();
	}
	this.loading = loading;
    }
    
    public List<TPEntry> getEntries()
    {
	return new ArrayList<TPEntry>(loaded.values());
    }
}
