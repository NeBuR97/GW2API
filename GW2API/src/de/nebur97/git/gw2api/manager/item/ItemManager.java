package de.nebur97.git.gw2api.manager.item;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;

import de.nebur97.git.gw2api.item.Item;
import de.nebur97.git.gw2api.manager.Manager;
import de.nebur97.git.gw2api.net.ItemLoader;


public class ItemManager extends Manager<Item>
{
    private HashMap<String,Item> itemName = new HashMap<String,Item>();
    private int errors = 0;
    private int idsToLoad;
    private List<Integer> ids;
    
    @Override
    public synchronized void add(Item i)
    {
	super.add(i);
	itemName.put(i.getName(), i);
	System.out.println(getProgress());
    }
    
    public synchronized Item get(String name)
    {
	return itemName.get(name);
    }

    @Override
    public void load(Collection<Integer> ids)
    {
	finishedTreads = 0;
	//remove duplicates
	List<Integer> tmp = new ArrayList<Integer>();
	for(int id : ids)
	{
	    if(!tmp.contains(id))
	    {
		tmp.add(id);
	    }
	}
	this.ids = tmp;
	tmp = null;
	
	idsToLoad = this.ids.size();
	//create a list for each thread
	List<List<Integer>> sub = new ArrayList<List<Integer>>();
	
	for(int a = 0; a < getThreadCount(); a++)
	{
	    sub.add(new ArrayList<Integer>());
	}
	
	int index = 0;
	System.out.println(sub.size());
	for(int id : ids)
	{
	    if(!isLoaded(id))
	    {
		 sub.get(index).add(id);
		 index++;
	    }
	    if(index == getThreadCount())
	    {
		index = 0;
	    }
	}
	
	for(List<Integer> l : sub)
	{
	    pool.execute(new ItemLoader(this,l));
	}
    }
    
    public synchronized void incrementErrors()
    {
	errors++;
    }
    
    @Override
    public boolean isFinished()
    {
	synchronized(entryIDs){
	    return entryIDs.size() == (idsToLoad-errors);
	}
    }
    
    public String getProgress()
    {
	return entryIDs.size()+"/"+(idsToLoad-errors);
    }
}
