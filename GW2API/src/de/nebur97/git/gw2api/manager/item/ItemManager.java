package de.nebur97.git.gw2api.manager.item;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
<<<<<<< HEAD

=======
>>>>>>> origin/master
import de.nebur97.git.gw2api.item.Item;
import de.nebur97.git.gw2api.manager.Manager;

public class ItemManager extends Manager<Item>
{
<<<<<<< HEAD
    private static final long serialVersionUID = 4744813022001326143L;
    private transient int errors = 0;
    private HashMap<String, Item> itemName = new HashMap<String, Item>();
=======
    private HashMap<String,Item> itemName = new HashMap<String,Item>();
    private int errors = 0;
    private int idsToLoad;
>>>>>>> origin/master
    
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
    
    public String getProgress()
    {
	synchronized(entryIDs) {
	    return entryIDs.size() + "/" + (idsToLoad - errors );
	}
    }
    
    @Override
<<<<<<< HEAD
    public void load(Collection<Integer> ids)
    {
	isLoading = true;
	finishedThreads = 0;
	// remove duplicates
	for(int id : ids) {
	    if(isLoaded(id)) {
		ids.remove(id);
		if(ids.isEmpty()) {
		    isLoading = false;
		    break;
		}
=======
    public void load(Collection<Integer> ids){
    	isLoading = true;
	finishedThreads = 0;
	//remove duplicates
	for(int id : ids)
	{
	    if(isLoaded(id))
	    {
	    	ids.remove(id);
>>>>>>> origin/master
	    }
	}
	
	idsToLoad = ids.size();
<<<<<<< HEAD
	// create a list for each thread
	List<List<Integer>> sub = new ArrayList<List<Integer>>();
	
	neededThreads = (idsToLoad < threadCount ) ? idsToLoad : threadCount;
	for(int a = 0; a < neededThreads; a++) {
=======
	//create a list for each thread
	List<List<Integer>> sub = new ArrayList<List<Integer>>();
	
	neededThreads = (idsToLoad < threadCount) ? idsToLoad : threadCount;
	for(int a = 0; a < neededThreads; a++)
	{
>>>>>>> origin/master
	    sub.add(new ArrayList<Integer>());
	}
	
	int index = 0;
	System.out.println(sub.size());
<<<<<<< HEAD
	for(int id : ids) {
	    sub.get(index).add(id);
	    index++;
	    if(index == neededThreads) {
=======
	for(int id : ids)
	{
		sub.get(index).add(id);
		index++;
	    if(index == neededThreads)
	    {
>>>>>>> origin/master
		index = 0;
	    }
	}
	
	for(List<Integer> l : sub) {
	    new ItemLoader(this, l).start();
	}
    }
    
    /**
     * 
     * @param id
     * @return True if this loader isn't loading anything else and is loading the id.
     */
    public boolean load(int id)
    {
	if( !isLoading()) {
	    load(Collections.singletonList(id));
	    return true;
	} else {
	    return false;
	}
    }
    
<<<<<<< HEAD
    synchronized void incrementErrors()
    {
	errors++;
    }
=======
    /*@Override
    public boolean isLoading()
    {
    	return isLoading;
    }*/
>>>>>>> origin/master
    
    synchronized void incrementFinishedThreads()
    {
<<<<<<< HEAD
	finishedThreads++;
	if(finishedThreads == neededThreads) {
	    synchronized(this) {
		isLoading = false;
	    }
	    
	}
=======
    	synchronized(entryIDs){
	return entryIDs.size()+"/"+(idsToLoad-errors);
    	}
>>>>>>> origin/master
    }
}
