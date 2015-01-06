package de.nebur97.git.gw2api.tradingpost;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import de.nebur97.git.gw2api.item.Item;

public class TradingPost implements Iterable<TPEntry>{
	private ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();
	private HashMap<Integer,TPEntry> loaded = new HashMap<Integer,TPEntry>();
	private TPCrawler crawler = new TPCrawler(this);
	
	public void loadPrice(int id)
	{
		queue.add(id);
		if(!crawler.isAlive())
		{
			crawler.start();
		}
	}
	
	public synchronized void add(TPEntry entry)
	{
		loaded.put(entry.getID(), entry);
	}
	
	ConcurrentLinkedQueue<Integer> getQueue()
	{
		return queue;
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
		for(Item i: items)
		{
			int id = i.getID();
			if(!isLoaded(id))
			{
				queue.add(i.getID());
			}
		}
	}
}
