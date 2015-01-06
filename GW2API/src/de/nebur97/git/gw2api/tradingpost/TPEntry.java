package de.nebur97.git.gw2api.tradingpost;

import de.nebur97.git.gw2api.item.Item;

public class TPEntry {
	private Item item;
	private int id;
	private double buy;
	private double sell;
	private int supply;
	private int demand;
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
	public double getBuy() {
		return buy;
	}
	public void setBuy(double buy) {
		this.buy = buy;
	}
	public double getSell() {
		return sell;
	}
	public void setSell(double sell) {
		this.sell = sell;
	}
	public int getSupply() {
		return supply;
	}
	public void setSupply(int supply) {
		this.supply = supply;
	}
	public int getDemand() {
		return demand;
	}
	public void setDemand(int demand) {
		this.demand = demand;
	}
	
	//0=id,1=buy,2=sell,3=supply,4=demand
	protected void setProperty(int c, int value)
	{
		switch(c)
		{
		case 0:
			id = value;
			break;
		case 1:
			buy = value;
			break;
		case 2:
			sell = value;
			break;
		case 3:
			supply = value;
			break;
		case 4:
			demand = value;
			break;
		}
	}
}
