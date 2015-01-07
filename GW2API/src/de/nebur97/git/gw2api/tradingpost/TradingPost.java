package de.nebur97.git.gw2api.tradingpost;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import de.nebur97.git.gw2api.GW2API;
import de.nebur97.git.gw2api.item.Item;
import de.nebur97.git.gw2api.item.flags.Flag;
import de.nebur97.git.gw2api.manager.item.ItemManager;

public class TradingPost implements Iterable<TPEntry>{
	private ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();
	private HashMap<Integer,TPEntry> loaded = new HashMap<Integer,TPEntry>();
	private GW2API api;
	private ItemManager iMan;
	protected boolean loading = false;
	public TradingPost(GW2API api)
	{
		this.api = api;
		iMan = api.getItemManager();
	}
	
	public synchronized void add(TPEntry entry)
	{
		loaded.put(entry.getID(), entry);
		Item i = iMan.get(entry.getID());
		i.setTradingPostEntry(entry);
		entry.setItem(i);
		
	}
	
	public boolean isLoaded(int id)
	{
		return loaded.containsKey(id);
	}
	
	public TPEntry getEntry(int id)
	{
		return loaded.get(id);
	}
	
	@Override
	public Iterator<TPEntry> iterator() {
		return loaded.values().iterator();
	}
	
	public void loadItems(Collection<Item> items)
	{
		if(!isLoading())
		{
			setLoading(true);
			List<Integer> ids = new ArrayList<Integer>();
			for(Item i: items)
			{
				if(!i.hasFlag(Flag.ACCOUNTBOUND) || !i.hasFlag(Flag.NOSELL))
				{
					ids.add(i.getID());
				}
			}
			new TPCrawler(this,ids).start();
		}
		
		
	}
	
	public void loadPrices(Collection<Integer> ids)
	{
		if(!isLoading())
		{
			setLoading(true);
			new TPCrawler(this, ids).start();
		}
	}
	
	public synchronized boolean isLoading()
	{
		return loading;
	}
	
	protected void setLoading(boolean loading)
	{
		this.loading = loading;
	}
	
	public static String copperValuetoGW2StandardCurrencyString(int copper)
	{
		String line = ""+copper;
        int l = line.length();
		if(l <= 2)
		{
			return line+" c";
		} else if(l <= 4)
		{
			return line.substring(0, (l == 3) ? 1 : 2) + " s " + line.substring(l-2,l);
		} else {
			return line.substring(0, l-4) + " g " + line.substring(l-4, l-2) + " s "+ line.substring(l-2)+ " c";
		}
	}
}
