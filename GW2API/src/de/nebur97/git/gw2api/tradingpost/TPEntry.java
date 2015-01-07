package de.nebur97.git.gw2api.tradingpost;

import de.nebur97.git.gw2api.item.Item;

public class TPEntry {
	private Item item;
	private int id;
	private int buy;
	private int sell;
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
	public int getBuy() {
		return buy;
	}
	public void setBuy(int buy) {
		this.buy = buy;
	}
	public int getSell() {
		return sell;
	}
	public void setSell(int sell) {
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
	
	public String getBuyPriceInGW2Format()
	{
		
        return TradingPost.copperValuetoGW2StandardCurrencyString(buy);
	}
	
	public String getSellPriceInGW2Format()
	{
		return TradingPost.copperValuetoGW2StandardCurrencyString(sell);
	}
	@Override
	public String toString()
	{
		return "id:"+id+",buy:"+buy+",sell:"+sell+",demand:"+demand+",supply:"+supply;
	}
}
