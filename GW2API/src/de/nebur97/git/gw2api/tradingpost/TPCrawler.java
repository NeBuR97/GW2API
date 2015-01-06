package de.nebur97.git.gw2api.tradingpost;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Queue;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

public class TPCrawler extends Thread {
	private TradingPost tp ;
	public TPCrawler(TradingPost tp)
	{
		this.tp = tp;
	}
	
	@Override
	public void run()
	{
		try {
			Queue<Integer> q = tp.getQueue();
			int queueSize = tp.getQueue().size();
			String ids = "";
			while(!q.isEmpty())
			{
				for(int a = 0; a < ((queueSize < 100) ? queueSize : 100);a++)
				{
					int id = q.poll();
					if(tp.isLoaded(id))
					{
						a--;
					} else {
						ids+=id+",";
					}
				}
				queueSize = q.size();
				JsonParser crawler = Json.createParser(new URL("http://api.gw2tp.com/1/items?ids="+ids+"&fields=buy,sell,supply,demand").openStream());
				TPEntry entry = new TPEntry();
				while(crawler.hasNext())
				{
					int index = 0;
					if(crawler.next() == Event.VALUE_NUMBER)
					{
						entry.setProperty(index, crawler.getInt());
						if(index == 4)
						{
							index = 0;
							tp.add(entry);
							System.out.println("Loaded "+entry.getID()+": "+entry.getBuy()+", "+entry.getSell()+", "+entry.getDemand()+", "+entry.getSupply());
							entry = new TPEntry();
						}
					}
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
