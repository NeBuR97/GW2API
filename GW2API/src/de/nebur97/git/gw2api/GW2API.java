package de.nebur97.git.gw2api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import de.nebur97.git.gw2api.item.Item;
import de.nebur97.git.gw2api.manager.item.ItemManager;
import de.nebur97.git.gw2api.manager.recipe.RecipeManager;
import de.nebur97.git.gw2api.recipe.Recipe;
import de.nebur97.git.gw2api.tradingpost.TPEntry;
import de.nebur97.git.gw2api.tradingpost.TradingPost;

public class GW2API
{
    private static GW2API api;
    private static final String iMSuffix = "/ItemManager.ser";
    private static final String rMSuffix = "/RecipeManager.ser";
    private static final String tPSuffix = "/TradingPost.ser";
    private ItemManager iCache = new ItemManager();
    private RecipeManager rCache = new RecipeManager();
    private int threads;
    private TradingPost tp = new TradingPost(this);
    
    private GW2API() throws Exception
    {
	int cores = Runtime.getRuntime().availableProcessors();
	if(cores <= 4) {
	    threads = (int) Math.pow(4, cores) / 2;
	} else {
	    threads = (int) Math.pow(2, cores);
	}
	iCache.setThreadCount(threads);
	rCache.setThreadCount(threads);
    }
    
    private GW2API(int threads) throws Exception
    {
	iCache.setThreadCount(threads);
	rCache.setThreadCount(threads);
	this.threads = threads;
    }
    
    /**
     * Get this API.
     * @return api
     */
    public static GW2API getInstance()
    {
	if(api == null) {
	    try {
		api = new GW2API();
	    }
	    catch(Exception e) {
		e.printStackTrace();
	    }
	    return api;
	} else {
	    return api;
	}
    }
    
    /**
     * Get this api with the number of threads.
     * @param threads
     * @return api
     */
    public static GW2API getInstance(int threads)
    {
	if(api == null) {
	    try {
		api = new GW2API(threads);
	    }
	    catch(Exception e) {
		e.printStackTrace();
	    }
	    return api;
	} else {
	    try {
		api.setThreadCount(threads);
	    }
	    catch(Exception e) {
		e.printStackTrace();
	    }
	    return api;
	}
    }
    
    /**
     * Get a list of ids, with a maximum size of maxSize. 0 or less for all ids.
     * @param maxSize
     * @return a List containing all loaded ids.
     * @throws MalformedURLException
     * @throws IOException
     */
    public List<Integer> getAllDiscoveredRecipeIDs(int maxSize) throws IOException
    {
	boolean hasMaxSize = maxSize > 0;
	JsonParser r = Json.createParser(new URL("https://api.guildwars2.com/v1/recipes.json").openStream());
	List<Integer> ids = new ArrayList<Integer>();
	
	while(r.hasNext()) {
	    if(r.next() == Event.VALUE_NUMBER) {
		ids.add(r.getInt());
		if(hasMaxSize && ids.size() == maxSize) {
		    break;
		}
	    }
	}
	
	return ids;
    }
    
    /**
     * Get the ItemManager
     * @return ItemManager
     */
    public ItemManager getItemManager()
    {
	return iCache;
    }
    
    /**
     * Get a List of all loaded items.
     * @return a list
     */
    public List<Item> getItems()
    {
	return iCache.getEntryList();
    }
    
    /**
     * Get a loaded item via its id.
     * @param id
     * @return the item or null if it isn't loaded.
     */
    public Item getItemViaID(int id)
    {
	return iCache.get(id);
    }
    
    /**
     * Get a loaded item via its name.
     * @param id
     * @return the item or null if it isn't loaded.
     */
    public Item getItemViaName(String name)
    {
	return iCache.get(name);
    }
    
    /**
     * Get the RecipeManager
     * @return RecipeManager
     */
    public RecipeManager getRecipeManager()
    {
	return rCache;
    }
    
    /**
     * Get a List of all loaded recipes.
     * @return a list
     */
    public List<Recipe> getRecipes()
    {
	return rCache.getEntryList();
    }
    
    /**
     * Get a recipe via its id.
     * @param id
     * @return the recipe or null
     */
    public Recipe getRecipeViaID(int id)
    {
	return rCache.get(id);
    }
    
    /**
     * Get a recipe via its output item's id.
     * @param outputID
     * @return the recipe or null
     */
    public Recipe getRecipeViaOutputID(int outputID)
    {
	return rCache.getRecipeViaOutputOD(outputID);
    }
    
    /**
     * @return The maximum number of threads.
     */
    public int getThreadCount()
    {
	return threads;
    }
    
    /**
     * Get the TradingPost object
     * @return the TradingPost used by this instance
     */
    public TradingPost getTradingPost()
    {
	return tp;
    }
    
    /**
     * Get a specfic TP entry
     * @param id
     * @return the tpentry or null
     */
    public TPEntry getTradingPostEntry(int id)
    {
	return tp.getEntry(id);
    }
    
    /**
     * Get a specfic TP entry
     * @param i
     * @return the entry or null
     */
    public TPEntry getTradingPostEntry(Item i)
    {
	return getTradingPostEntry(i.getID());
    }
    
    /**
     * Check if the itemmanager is loading
     * @return true if its loading, false if not
     */
    public boolean itemsAreBeingLoaded()
    {
	return iCache.isLoading();
    }
    
    /**
     * Load all caches from the given path
     * @param f
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void loadAll(File f) throws IOException, ClassNotFoundException
    {
	String loc = f.getAbsolutePath() + "/";
	ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(loc + iMSuffix)));
	iCache = (ItemManager) ois.readObject();
	ois.close();
	
	ois = new ObjectInputStream(new FileInputStream(new File(loc + rMSuffix)));
	rCache = (RecipeManager) ois.readObject();
	ois.close();
	
	ois = new ObjectInputStream(new FileInputStream(new File(loc + tPSuffix)));
	tp = (TradingPost) ois.readObject();
	tp.setItemManager(iCache);
	ois.close();
    }
    
    /**
     * Loads all recipes discovered.
     * @return the number of recipes being loaded ~9000
     * @throws MalformedURLException
     * @throws IOException
     */
    public int loadAllDiscoveredRecipes() throws MalformedURLException, IOException
    {
	if( !rCache.isLoading()) {
	    List<Integer> ids = getAllDiscoveredRecipeIDs(0);
	    loadRecipes(ids);
	    return ids.size();
	} else {
	    throw new IOException("RecipeManager is already loading recipes!");
	}
    }
    
    /**
     * Load the Items defined by these ids.
     * @param ids
     * @return true if loading has started, false if items are already being loaded.
     */
    public boolean loadItems(Collection<Integer> ids)
    {
	if( !iCache.isLoading()) {
	    iCache.load(ids);
	    return true;
	} else {
	    return false;
	}
    }
    
    /**
     * Load the recipes defined by these ids.
     * @param ids
     * @return true if loading has started, false if recipes are already being loaded.
     */
    public boolean loadRecipes(Collection<Integer> ids)
    {
	if( !rCache.isLoading()) {
	    rCache.load(ids);
	    return true;
	} else {
	    return false;
	}
    }
    
    /**
     * Load a single item (this method is blocking)
     * @param id
     * @return the item.
     */
    public Item loadSingleItem(int id)
    {
	if(iCache.isLoaded(id)) {
	    return iCache.get(id);
	} else {
	    iCache.load(id);
	    while(iCache.isLoading()) {}
	    return iCache.get(id);
	}
    }
    
    /**
     * Load trading post entries.
     * @param ids
     */
    public void loadTPEntriesViaIDs(Collection<Integer> ids)
    {
	tp.loadEntries(ids);
    }
    
    /**
     * Load trading post entries.
     * @param items
     */
    public void loadTPEntriesViaItems(Collection<Item> items)
    {
	tp.loadItemEntries(items);
    }
    
    /**
     * Check if the TP is loading
     * @return true if loading
     */
    public boolean pricesAreBeingLoaded()
    {
	return tp.isLoading();
    }
    
    /**
     * Check if the recipemanager is loading
     * @return true if its loading, false if not
     */
    public boolean recipesAreBeingLoaded()
    {
	return rCache.isLoading();
    }
    
    /**
     * Refresh the TP's entries.
     */
    public void refreshTPEntries()
    {
	tp.refresh();
    }
    
    /**
     * Save all caches to the given directory. Three seperate files will be created:<li>ItemManager.ser <li>RecipeManager.ser <li>TradingPost.ser
     * @param dest
     * @throws IOException
     * @throws URISyntaxException
     */
    public void saveAll(File dest) throws IOException, URISyntaxException
    {
	if( !dest.isDirectory()) {
	    throw new IOException("You can only save in directories!");
	}
	String loc = dest.getAbsolutePath() + "/";
	System.out.println("Saving to " + loc);
	ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(loc + iMSuffix)));
	oos.writeObject(iCache);
	oos.close();
	
	oos = new ObjectOutputStream(new FileOutputStream(new File(loc + rMSuffix)));
	oos.writeObject(rCache);
	oos.close();
	
	oos = new ObjectOutputStream(new FileOutputStream(new File(loc + tPSuffix)));
	oos.writeObject(tp);
	oos.close();
    }
    
    /**
     * Save all caches to the given directory. Three seperate files will be created:<li>ItemManager.ser <li>RecipeManager.ser <li>TradingPost.ser
     * @param dest
     * @throws IOException
     * @throws URISyntaxException
     */
    public void saveAll(String dest) throws URISyntaxException, IOException
    {
	File f = new File(dest);
	saveAll(f);
    }
    
    /**
     * Set the maximum amount of threads to use when loading stuff.
     * @param threads
     * @throws Exception if the api's currently loading.
     */
    public void setThreadCount(int threads) throws Exception
    {
	try {
	    iCache.setThreadCount(threads);
	    rCache.setThreadCount(threads);
	    this.threads = threads;
	}
	catch(Exception e) {
	    throw e;
	}
    }
    
    public List<TPEntry> getTradingPostEntries()
    {
	return tp.getEntries();
    }
    
    public int getItemLoadingErrors()
    {
	return iCache.getLoadingErrors();
    }
}
