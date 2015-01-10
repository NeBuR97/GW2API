package de.nebur97.git.gw2api.manager.recipe;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import de.nebur97.git.gw2api.recipe.Recipe;

public class RecipeLoader extends Thread
{
    public static String RECIPE_API = "https://api.guildwars2.com/v2/recipes/";
    private RecipeManager cache;
    private List<Integer> ids = new ArrayList<Integer>();
    private JsonParser p;
    private Recipe r;
    
    RecipeLoader(RecipeManager cache, List<Integer> idsToLoad)
    {
	ids = idsToLoad;
	this.cache = cache;
    }
    
    @Override
    public void run()
    {
	long start = System.currentTimeMillis();
	int c = 0;
	for(int id : ids) {
	    start = System.currentTimeMillis();
	    r = new Recipe();
	    try {
		p = Json.createParser(new URL(RECIPE_API + id).openStream());
		while(p.hasNext()) {
		    Event e = p.next();
		    if(e == Event.KEY_NAME) {
			String name = p.getString();
			switch(name)
			{
			    case "disciplines":
				basicArray(name);
				break;
			    case "flags":
				basicArray(name);
				break;
			    case "ingredients":
				while((e = p.next() ) != Event.END_ARRAY) {
				    
				    if(e == Event.START_OBJECT) {
					// 0 = id, 1 = count
					int[] ing = new int[2];
					
					// Will be Event.KEY_NAME: item_id
					p.next();
					// Event.VALUE_NUMBER
					p.next();
					ing[0] = p.getInt();
					
					// will be Event.KEY_NAME
					p.next();
					
					// Event.VALUE_NUMBER
					p.next();
					ing[1] = p.getInt();
					
					r.setProperty(name, ing);
				    }
				}
				break;
			    default:
				e = p.next();
				r.setProperty(name, e == Event.VALUE_STRING ? p.getString() : p.getInt());
			}
		    }
		}
	    }
	    catch(MalformedURLException e) {
		e.printStackTrace();
	    }
	    catch(IOException e) {
		e.printStackTrace();
	    }
	    c++;
	    cache.add(r);
	    System.out.println(getName() + " loaded recipe: " + c + "/" + ids.size() + " " + r.getID() + " in " + (System.currentTimeMillis() - start ) + "ms");
	}
	cache.incrementFinishedThreads();
	System.out.println(getName() + " is finished, total of " + cache.getFinishedThreads() + " finished threads.");
    }
    
    private void basicArray(String name)
    {
	p.next();
	while(p.next() != Event.END_ARRAY) {
	    r.setProperty(name, p.getString());
	}
    }
}
