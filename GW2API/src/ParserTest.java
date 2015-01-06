import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import de.nebur97.git.gw2api.item.Item;
import de.nebur97.git.gw2api.manager.item.ItemManager;
import de.nebur97.git.gw2api.manager.recipe.RecipeManager;
import de.nebur97.git.gw2api.recipe.Recipe;

public class ParserTest
{
    
    public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException
    {
	/*long start = System.currentTimeMillis();
	JsonParser p = Json.createParser(new URL("https://api.guildwars2.com/v1/items.json").openStream());
	List<Integer> ids = new ArrayList<Integer>();
	
	while(p.hasNext()) {
	    if(p.next() == Event.VALUE_NUMBER) {
		ids.add(p.getInt());
		System.out.println(p.getInt());
		if(ids.size() == 5) {
		    p.close();
		    break;
		}
	    }
	}
	ItemManager man = new ItemManager();
	System.out.println("Loading " + ids.size() + " ids with " + man.getThreadCount() + " threads.");
	man.load(ids);
	
	while( !man.isFinished()) {
	}
	System.out.println(man.getEntryList().size());
	System.out.println("Time taken: " + (System.currentTimeMillis() - start ));
	
	for(Item i : man.getEntryList())
	{
	    System.out.println(i);
	}*/
    	
    	/*JsonParser r = Json.createParser(new URL("https://api.guildwars2.com/v2/recipes/7319").openStream());
    	while(r.hasNext())
    	{
    		Event e = r.next();
    		if(e == Event.KEY_NAME || e == Event.VALUE_STRING)
    		{
    			System.out.println(e + ":" + r.getString());
    		} else if(e == Event.VALUE_NUMBER)
    		{
    			System.out.println(e + ":" + r.getInt());
    		} else {
    			System.out.println(e);
    		}
    	}*/
    	
    	JsonParser r = Json.createParser(new URL("https://api.guildwars2.com/v1/recipes.json").openStream());
    	List<Integer> ids = new ArrayList<Integer>();
    	
    	while(r.hasNext())
    	{
    		if(r.next() == Event.VALUE_NUMBER)
    		{
    			ids.add(r.getInt());
    			if(ids.size() == 100)
    			{
    				break;
    			}
    		}
    	}
    	
    	long start = System.currentTimeMillis();
    	RecipeManager man = new RecipeManager();
    	man.load(ids);
    	
    	while(!man.isFinished())
    	{
    		
    	}
    	System.out.println("Loaded "+man.getEntryList().size()+" in "+ (System.currentTimeMillis() - start)+"ms");

    	for(Recipe re : man.getEntryList())
    	{
    		System.out.println(re);
    	}
    }
    
}
