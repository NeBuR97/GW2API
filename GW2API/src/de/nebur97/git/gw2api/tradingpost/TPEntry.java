package de.nebur97.git.gw2api.tradingpost;

import java.io.Serializable;

import de.nebur97.git.gw2api.item.Item;

public class TPEntry implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 2237053978430581438L;
    private int buy;
    private int demand;
    private int id;
    private transient Item item;
    private int sell;
    private int supply;
    
    public int getBuy()
    {
	return buy;
    }
    
    public String getBuyPriceInGW2Format()
    {
	
	return TradingPost.copperValueToGW2StandardCurrencyString(buy);
    }
    
    public int getDemand()
    {
	return demand;
    }
    
    public int getID()
    {
	return id;
    }
    
    public Item getItem()
    {
	return item;
    }
    
    public int getSell()
    {
	return sell;
    }
    
    public String getSellPriceInGW2Format()
    {
	return TradingPost.copperValueToGW2StandardCurrencyString(sell);
    }
    
    public int getSupply()
    {
	return supply;
    }
    
    public void setBuy(int buy)
    {
	this.buy = buy;
    }
    
    public void setDemand(int demand)
    {
	this.demand = demand;
    }
    
    public void setID(int id)
    {
	this.id = id;
    }
    
    public void setItem(Item item)
    {
	this.item = item;
    }
    
    public void setSell(int sell)
    {
	this.sell = sell;
    }
    
    public void setSupply(int supply)
    {
	this.supply = supply;
    }
    
    @Override
    public String toString()
    {
	return "id:" + id + ",buy:" + buy + ",sell:" + sell + ",demand:" + demand + ",supply:" + supply;
    }
}
