package de.nebur97.git.gw2api.manager.item;

import java.net.URL;
import java.util.List;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import de.nebur97.git.gw2api.item.Item;
import de.nebur97.git.gw2api.item.attributes.Attribute;

/**
 * A thread to load items based on a list of ids.
 * 
 * @author NeBuR97
 * 
 */
public class ItemLoader extends Thread implements Runnable
{
    public static String ITEM_API_URL = "https://api.guildwars2.com/v2/items/";
    private ItemManager cache;
    private List<Integer> ids;
    private Item item;
    private JsonParser parser;
    
    /**
     * Create a new Thread with the list of ids.
     * 
     * @param ids
     */
    ItemLoader(ItemManager manager, List<Integer> ids)
    {
	this.ids = ids;
	cache = manager;
	System.out.println("Created a new ItemLoader with " + ids.size() + " ids.");
    }
    
    @Override
    public void run()
    {
	// Go through all ids.
	int c = 0;
	for(int id : ids) {
	    long start = System.currentTimeMillis();
	    try {
		parser = Json.createParser(new URL(ITEM_API_URL + id).openStream());
		item = new Item();
		
		boolean subtype = false;
		while(parser.hasNext()) {
		    Event e = parser.next();
		    if(e == Event.KEY_NAME) {
			String name = parser.getString();
			switch(name)
			{
			    case "type":
				parser.next();
				if( !subtype) {
				    item = item.createSubItem(parser.getString());
				    subtype = true;
				    break;
				} else {
				    item.setProperty(name, parser.getString());
				    break;
				}
				
			    case "game_types":
				basicArray(name);
				break;
			    case "flags":
				basicArray(name);
				break;
			    case "restrictions":
				basicArray(name);
				break;
			    case "infusion_slots":
				basicArray(name);
				break;
			    case "details":
				while((e = parser.next() ) != Event.END_OBJECT) {
				    String key;
				    if(e == Event.KEY_NAME) {
					key = parser.getString();
					switch(key)
					{
					    case "infusion_slots":
						basicArray(key);
						break;
					    case "infix_upgrade":
						while((e = parser.next() ) != Event.END_OBJECT) {
						    if(e == Event.KEY_NAME) {
							if(parser.getString().equals("attributes")) {
							    String stat = null;
							    while((e = parser.next() ) != Event.END_ARRAY) {
								if(e == Event.KEY_NAME) {
								    if(parser.getString().equals("attribute")) {
									// will
									// be
									// VALUE_STRING
									parser.next();
									stat = parser.getString();
									
									// will
									// be
									// KEY_NAME
									// :
									// modifier
									parser.next();
									
									// will
									// be
									// VALUE_NUMBER
									parser.next();
									item.setProperty("attribute", Attribute.createAttribute(stat, parser.getInt()));
								    }
								}
							    }
							} else {
							    item.setProperty(key, (parser.next() == Event.VALUE_STRING ) ? parser.getString() : parser.getInt());
							}
						    }
						}
						break;
					    default:
						item.setProperty(key, (parser.next() == Event.VALUE_STRING ) ? parser.getString() : parser.getInt());
					}
				    }
				}
				break;
			    default: {
				e = parser.next();
				item.setProperty(name, ((e == Event.VALUE_STRING ) ? parser.getString() : parser.getInt() ));
			    }
			}
		    }
		}
		c++;
		System.out.println(this.getName() + " loaded item: " + c + "/" + ids.size() + " " + item.getID() + "," + item.getName() + " in " + (System.currentTimeMillis() - start ) + "ms");
		cache.add(item);
	    }
	    catch(Exception e) {
		c++;
		System.err.println(c + " Error at " + id);
		cache.incrementErrors();
	    }
	    
	}
	cache.incrementFinishedThreads();
	System.out.println(getName() + " is finished, total of " + cache.getFinishedThreads() + " finished threads.");
    }
    
    private void basicArray(String name)
    {
	parser.next();
	while(parser.next() != Event.END_ARRAY) {
	    item.setProperty(name, parser.getString());
	}
    }
}
