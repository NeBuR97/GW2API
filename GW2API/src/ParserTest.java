import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import de.nebur97.git.gw2api.GW2API;
import de.nebur97.git.gw2api.item.Item;
import de.nebur97.git.gw2api.manager.item.ItemManager;
import de.nebur97.git.gw2api.manager.recipe.RecipeManager;
import de.nebur97.git.gw2api.recipe.Recipe;
import de.nebur97.git.gw2api.tradingpost.TPEntry;

public class ParserTest
{
    
    public static void main(String[] args) throws MalformedURLException, IOException
    {
    	GW2API api = null;
		try {
			api = new GW2API();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	api.loadRecipes(api.getAllDiscoveredRecipeIDs(10));
    	
    	while(api.recipesAreBeingLoaded()){}
    	System.out.println(api.getRecipeManager().getEntryList().size()+" recipes");
    	
    	List<Integer> ids = new ArrayList<Integer>();
    	for(Recipe r : api.getRecipes())
    	{
    		ids.add(r.getOutputItemID());
    	}
    	
    	api.loadItems(ids);
    	
    	while(api.itemsAreBeingLoaded()){}
    	
    	System.out.println(api.getItems().size() + " items loaded");
    	
    	api.loadPrices(api.getItems());
    	
    	while(api.pricesAreBeingLoaded())
    	{
    		
    	}
    	
    	for(Item i : api.getItems())
    	{
    		TPEntry tpe = i.getTradingPostEntry();
    		System.out.println(i.getName()+": "+tpe.getBuyPriceInGW2Format());
    	}
    }
    
}
