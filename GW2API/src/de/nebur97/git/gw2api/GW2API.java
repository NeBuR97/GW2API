package de.nebur97.git.gw2api;

import java.io.IOException;
import java.net.MalformedURLException;
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

public class GW2API {
	private ItemManager iCache = new ItemManager();
	private RecipeManager rCache = new RecipeManager();
	private TradingPost tp = new TradingPost(this);
	private int threads;
	
	public GW2API() throws Exception{
		int cores = Runtime.getRuntime().availableProcessors();
		if(cores <= 4)
		{
			threads = (int)Math.pow(4, cores)/2;
		} else {
			threads = (int)Math.pow(2, cores);
		}
		iCache.setThreadCount(threads);
		rCache.setThreadCount(threads);
	}
	public GW2API(int threads) throws Exception
	{
		iCache.setThreadCount(threads);
		rCache.setThreadCount(threads);
		this.threads = threads;
	}
	
	public void setThreadCount(int threads) throws Exception
	{
		try {
			iCache.setThreadCount(threads);
			rCache.setThreadCount(threads);
			this.threads = threads;
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	public int getThreadCount()
	{
		return threads;
	}
	
	public boolean loadItems(Collection<Integer> ids)
	{
		if(!iCache.isLoading())
		{
			iCache.load(ids);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean loadRecipes(Collection<Integer> ids)
	{
		if(!rCache.isLoading())
		{
			rCache.load(ids);
			return true;
		} else {
			return false;
		}
	}
	
	public int loadAllRecipesCurrentlyDiscovered() throws MalformedURLException, IOException
	{
		if(!rCache.isLoading())
		{
	    	List<Integer> ids = getAllDiscoveredRecipeIDs(0);
	    	loadRecipes(ids);
	    	return ids.size();
		} else {
			throw new IOException("RecipeManager is already loading recipes!");
		}
	}
	
	public List<Integer> getAllDiscoveredRecipeIDs(int maxSize) throws MalformedURLException, IOException
	{
		boolean hasMaxSize = maxSize > 0;
		JsonParser r = Json.createParser(new URL("https://api.guildwars2.com/v1/recipes.json").openStream());
    	List<Integer> ids = new ArrayList<Integer>();
    	
    	while(r.hasNext())
    	{
    		if(r.next() == Event.VALUE_NUMBER)
    		{
    			ids.add(r.getInt());
    			if(hasMaxSize && ids.size() == maxSize)
    			{
    				break;
    			}
    		}
    	}
    	
    	return ids;
	}
	public ItemManager getItemManager()
	{
		return iCache;
	}
	
	public RecipeManager getRecipeManager()
	{
		return rCache;
	}
	
	public Item getItemViaID(int id)
	{
		return iCache.get(id);
	}
	
	public Item getItemViaName(String name)
	{
		return iCache.get(name);
	}
	
	public Recipe getRecipeViaID(int id)
	{
		return rCache.get(id);
	}
	
	public Recipe getRecipeViaOutputID(int outputID)
	{
		return rCache.getRecipeViaOutputOD(outputID);
	}
	
	public void loadPricesViaIDs(Collection<Integer> ids)
	{
		tp.loadPrices(ids);
	}
	
	public void loadPrices(Collection<Item> items)
	{
		tp.loadItems(items);
	}
	
	public TPEntry getTradinPostEntry(int id)
	{
		return tp.getEntry(id);
	}
	
	public boolean recipesAreBeingLoaded()
	{
		return rCache.isLoading();
	}
	
	public boolean itemsAreBeingLoaded()
	{
		return iCache.isLoading();
	}
	
	public List<Recipe> getRecipes()
	{
		return rCache.getEntryList();
	}
	
	public List<Item> getItems()
	{
		return iCache.getEntryList();
	}
	
	public TradingPost getTradingPost()
	{
		return tp;
	}
	
	public boolean pricesAreBeingLoaded()
	{
		return tp.isLoading();
	}
	
	public TPEntry getTradingPostEntry(Item i)
	{
		return getTradingPostEntry(i.getID());
	}
	
	public TPEntry getTradingPostEntry(int id)
	{
		return tp.getEntry(id);
	}
}
