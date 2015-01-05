package de.nebur97.git.gw2api.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * This class provides features to manage items and recipes.
 * @author NeBuR97
 **/
public abstract class Manager<T>
{
    protected HashMap<Integer,T> entryIDs = new HashMap<Integer,T>();
    protected int threadCount = (int)Math.pow(2, Runtime.getRuntime().availableProcessors());
    protected Executor pool = Executors.newFixedThreadPool(threadCount);
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
    
    /**
     * Adds an entry.
     * @param obj
     */
    public synchronized void add(T obj)
    {
	entryIDs.put(((EntryWithID)obj).getID(), obj);
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
     * Checks if the map contains this id (contained in the map = loaded).
     * @param id
     * @return true if the entry is present and loaded.
     * @see #isLoaded(Object)
     */
    public boolean isLoaded(int id)
    {
	return entryIDs.containsKey(id);
    }
    
    /**
     * Load the ids contained in the collection. This method is non-blocking because it utilizes threads to load the entries.<br>
     * The amount of threads is specified by {@link #setThreadCount(int)} or defaults to 2^{@link Runtime#availableProcessors()}
     * @param ids - The collection containing the ids to load.
     */
    abstract public void load(Collection<Integer> ids);
    
    public void setThreadCount(int threads)
    {
	threadCount = threads;
	pool = Executors.newFixedThreadPool(threadCount);
    }
    
    public int getThreadCount()
    {
	return threadCount;
    }
}
