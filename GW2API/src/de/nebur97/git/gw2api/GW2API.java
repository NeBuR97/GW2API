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
	private TradingPost tp = new TradingPost();
	private int threads;
	
	public GW2API(){
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
	public GW2API(int threads)
	{
		iCache.setThreadCount(threads);
		rCache.setThreadCount(threads);
		this.threads = threads;
	}
	
	public void setThreadCount(int threads)
	{
		iCache.setThreadCount(threads);
		rCache.setThreadCount(threads);
		this.threads = threads;
	}
	
	public int getThreadCount()
	{
		return threads;
	}
	
	public boolean loadItems(Collection<Integer> ids)
	{
		if(iCache.isFinished())
		{
			iCache.load(ids);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean loadRecipes(Collection<Integer> ids)
	{
		if(rCache.isFinished())
		{
			rCache.load(ids);
			return true;
		} else {
			return false;
		}
	}
	
	public int loadAllRecipesCurrentlyDiscovered() throws MalformedURLException, IOException
	{
		if(rCache.isFinished())
		{
			JsonParser r = Json.createParser(new URL("https://api.guildwars2.com/v1/recipes.json").openStream());
	    	List<Integer> ids = new ArrayList<Integer>();
	    	
	    	while(r.hasNext())
	    	{
	    		if(r.next() == Event.VALUE_NUMBER)
	    		{
	    			ids.add(r.getInt());
	    		}
	    	}
	    	loadRecipes(ids);
	    	return ids.size();
		} else {
			return -1;
		}
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
		for(int id : ids)
		{
			tp.loadPrice(id);
		}
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
		return !rCache.isFinished();
	}
	
	public boolean itemsAreBeingLoaded()
	{
		return !iCache.isFinished();
	}
	
	public List<Recipe> getRecipes()
	{
		return rCache.getEntryList();
	}
	
	public List<Item> getItems()
	{
		return iCache.getEntryList();
	}
}
