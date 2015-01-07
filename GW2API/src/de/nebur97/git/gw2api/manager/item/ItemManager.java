package de.nebur97.git.gw2api.manager.item;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import de.nebur97.git.gw2api.item.Item;
import de.nebur97.git.gw2api.manager.Manager;
import de.nebur97.git.gw2api.net.ItemLoader;


public class ItemManager extends Manager<Item>
{
    private HashMap<String,Item> itemName = new HashMap<String,Item>();
    private int errors = 0;
    private int idsToLoad;
    
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
    public void load(Collection<Integer> ids){
    	isLoading = true;
	finishedThreads = 0;
	//remove duplicates
	for(int id : ids)
	{
	    if(isLoaded(id))
	    {
	    	ids.remove(id);
	    }
	}
	
	idsToLoad = ids.size();
	//create a list for each thread
	List<List<Integer>> sub = new ArrayList<List<Integer>>();
	
	neededThreads = (idsToLoad < threadCount) ? idsToLoad : threadCount;
	for(int a = 0; a < neededThreads; a++)
	{
	    sub.add(new ArrayList<Integer>());
	}
	
	int index = 0;
	System.out.println(sub.size());
	for(int id : ids)
	{
		sub.get(index).add(id);
		index++;
	    if(index == neededThreads)
	    {
		index = 0;
	    }
	}
	
	for(List<Integer> l : sub)
	{
	    executeThread(new ItemLoader(this,l));
	}
    }
    
    public synchronized void incrementErrors()
    {
	errors++;
    }
    
    /*@Override
    public boolean isLoading()
    {
    	return isLoading;
    }*/
    
    public String getProgress()
    {
    	synchronized(entryIDs){
	return entryIDs.size()+"/"+(idsToLoad-errors);
    	}
    }
}
