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

public class ParserTest
{
    
    public static void main(String[] args) throws MalformedURLException, IOException
    {
    	GW2API api = new GW2API();
    	api.loadAllRecipesCurrentlyDiscovered();
    	
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
    }
    
}
