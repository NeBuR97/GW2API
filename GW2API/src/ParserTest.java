import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import de.nebur97.git.gw2api.manager.item.ItemManager;

public class ParserTest
{
    
    public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException
    {
	System.out.println("u wot");
	JsonParser p = Json.createParser(new URL("https://api.guildwars2.com/v1/items.json").openStream());
	List<Integer> ids = new ArrayList<Integer>();
	
	/*while(p.hasNext())
	{
	    if(p.next() == Event.VALUE_NUMBER)
	    {
		ids.add(p.getInt());
		System.out.println(p.getInt());
	    }
	}*/
	
	ids.add(18431);
	ids.add(13288);
	ItemManager man = new ItemManager();
	System.out.println("Loading "+ids.size()+" ids with "+man.getThreadCount()+" threads.");
	man.load(ids);
	
	while(!man.isFinished()){}
	System.out.println(man.get(18431));
    }
    
}
