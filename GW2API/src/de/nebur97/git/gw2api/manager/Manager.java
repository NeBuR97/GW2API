package de.nebur97.git.gw2api.manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * This class provides features to manage items and recipes.
 * @author NeBuR97
 **/
public abstract class Manager<T> implements Serializable
{
    private static final long serialVersionUID = 1958428812706515101L;
    protected HashMap<Integer, T> entryIDs = new HashMap<Integer, T>();
    protected transient int finishedThreads = 0;
    protected transient int idsToLoad;
    protected transient boolean isLoading = false;
    protected transient int neededThreads = 0;
    protected transient int threadCount = (int) Math.pow(2, Runtime.getRuntime().availableProcessors());
    
    /**
     * Adds an entry.
     * @param obj
     */
    public synchronized void add(T obj)
    {
	entryIDs.put(((EntryWithID) obj ).getID(), obj);
    }
    
    /**
     * Get an element via it's id. Returns null if no element is present (although the map may contain a null value, I believe recipes and items will never be null, thus making null a definitive return type).
     * @param id
     * @return The entry with the given id or null if no such element is present.
     */
    public synchronized T get(int id)
    {
	return entryIDs.get(id);
    }
    
    /**
     * Gets a list of all entries.
     * @return an arraylist of all entries.
     */
    public synchronized ArrayList<T> getEntryList()
    {
	return new ArrayList<T>(entryIDs.values());
    }
    
    public int getFinishedThreads()
    {
	return finishedThreads;
    }
    
    /**
     * Get the threadcount
     * @return this manager's threadcount
     */
    public int getThreadCount()
    {
	return threadCount;
    }
    
    /**
     * Checks if the map contains this id (contained in the map = loaded).
     * @param id
     * @return true if the entry is present and loaded.
     * @see #isLoaded(Object)
     */
    public synchronized boolean isLoaded(int id)
    {
	return entryIDs.containsKey(id);
    }
    
    /**
     * Checks, if an object is already in the entry map (contained in the map = loaded).
     * @param obj
     * @return true if the entry is loaded
     */
    public boolean isLoaded(T obj)
    {
	return entryIDs.containsValue(obj);
    }
    
    /**
     * Check if this manager is loading.
     * @return isLoading
     */
    public boolean isLoading()
    {
	synchronized(this) {
	    return isLoading;
	}
    }
    
    /**
     * Load the ids contained in the collection. This method is non-blocking because it utilizes threads to load the entries.<br>
     * The amount of threads is specified by {@link #setThreadCount(int)} or defaults to 2^{@link Runtime#availableProcessors()}
     * @param ids - The collection containing the ids to load.
     */
    abstract public void load(Collection<Integer> ids);
    
    /**
     * Set the amount of threads to use.
     * @param threads
     * @throws Exception - When threads are currently running
     */
    public void setThreadCount(int threads) throws Exception
    {
	if( !isLoading()) {
	    threadCount = threads;
	} else {
	    throw new Exception("You cannot change the threadcount while threads are running!");
	}
    }
    
}
