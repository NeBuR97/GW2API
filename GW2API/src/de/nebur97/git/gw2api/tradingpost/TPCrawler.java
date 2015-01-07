package de.nebur97.git.gw2api.tradingpost;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

public class TPCrawler extends Thread {
	private TradingPost tp ;
	private List<Integer> ids;
	private JsonParser crawler;
	private TPEntry entry;
	public TPCrawler(TradingPost tp, Collection<Integer> ids)
	{
		this.tp = tp;
		this.ids = new ArrayList<Integer>(ids);
	}
	
	@Override
	public void run()
	{
		try {
			String idsStr = "";
			int idsSize = ids.size();
			int idsPerQuery = (idsSize < 200) ? idsSize : 200;
			for(int a = 0; a < idsSize; a+=idsPerQuery)
			{
				for(int b = a; b < idsPerQuery;b++)
				{
					int id = ids.get(b);
					idsStr+=id+",";
				}
				crawler = Json.createParser(new URL("https://api.guildwars2.com/v2/commerce/prices?ids="+idsStr).openStream());
				entry = new TPEntry();
				while(crawler.hasNext())
				{
					/*Event e = crawler.next();
					if(e == Event.KEY_NAME)
					{
						System.out.println(e+":"+crawler.getString());
					} else if(e == Event.VALUE_STRING || e == Event.VALUE_NUMBER)
					{
						System.out.println(e+":"+((e == Event.VALUE_STRING) ? crawler.getString() : crawler.getInt()));
					} else {
						System.out.println(e);
					}*/
					
					Event e = crawler.next();
					if(e == Event.KEY_NAME)
					{
						switch(crawler.getString())
						{
						case "id":
							crawler.next();
							entry.setID(crawler.getInt());
							break;
						case "buys":
							object(true);
							break;
						case "sells":
							object(false);
							tp.add(entry);
							entry = new TPEntry();
							break;
						}
					}
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		tp.setLoading(false);
		System.out.println("TPCrawler is done!");
	}
	
	private void object(boolean buys)
	{
		Event e;
		while((e = crawler.next()) != Event.END_OBJECT)
		{
			if(e == Event.KEY_NAME)
			{
				switch(crawler.getString())
				{
					case "quantity":
						crawler.next();
						if(buys)
						{
							entry.setDemand(crawler.getInt());
						} else {
							entry.setSupply(crawler.getInt());
						}
						break;
					case "unit_price":
						crawler.next();
						if(buys)
						{
							entry.setBuy(crawler.getInt());
						} else {
							entry.setSell(crawler.getInt());
						}
						break;
				}
			}
		}
	}
}
