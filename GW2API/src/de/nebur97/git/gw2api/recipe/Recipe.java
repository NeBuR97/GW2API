package de.nebur97.git.gw2api.recipe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import de.nebur97.git.gw2api.item.Item;
import de.nebur97.git.gw2api.manager.EntryWithID;
import de.nebur97.git.gw2api.recipe.disciplines.Discipline;
import de.nebur97.git.gw2api.recipe.flags.RecipeFlag;
import de.nebur97.git.gw2api.type.Type;
import de.nebur97.git.gw2api.type.craftingmaterial.CraftingMaterialType;
import de.nebur97.git.gw2api.type.food.FoodType;
import de.nebur97.git.gw2api.type.refinement.RefinementType;

/**
 * An object representing a recipe.
 * 
 * @author NeBuR97
 **/
public class Recipe implements EntryWithID, Serializable
{
<<<<<<< HEAD
    private static final long serialVersionUID = 3405428868960116050L;
    
    private List<Discipline> disciplines = new ArrayList<Discipline>();
    private RecipeFlag flag;
    private int id;
    // ID,Count
    private HashMap<Integer, Integer> ingredients = new HashMap<Integer, Integer>();
    private int minRating;
    private transient Item outputItem;
=======
    /**
	 * 
	 */
	private static final long serialVersionUID = 3405428868960116050L;
	private int id;
    private Object type;
    private int outputItemID;
>>>>>>> origin/master
    private int outputItemCount;
    private int outputItemID;
    private String outputItemName;
    
    private int timeToCraftMs;
    private Object type;
    
    /**
     * Adds a discipline
     * @param d
     */
    public void addDiscipline(Discipline d)
    {
	disciplines.add(d);
    }
    
    /**
     * Adds a discipline via string.
     * @param d
     */
    public void addDiscipline(String d)
    {
	addDiscipline(Discipline.valueOf(d.toUpperCase()));
    }
    
    /**
     * Adds an ingredient.
     * @param id - the item's id
     * @param count - the amount needed
     */
    public void addIngredient(int id, int count)
    {
	ingredients.put(id, count);
    }
    
    /**
     * Gets an array of all discplines added to this recipes.
     * @return array of disciplines
     */
    public Discipline[] getDisciplines()
    {
	return disciplines.toArray(new Discipline[disciplines.size()]);
    }
    
    /**
     * Get this recipe's id.
     * @return the id
     */
    @Override
    public int getID()
    {
<<<<<<< HEAD
	return id;
    }
    
    public int getIngredientCount(int id)
    {
	return ingredients.get(id);
=======
	Object t = Type.getType(s);
	if(t == Type.NONE)
	{
	   try{
	       t = FoodType.valueOf(s.toUpperCase());
	       type = t;
	       return;
	   }catch(Exception e)
	   {
	       //System.err.println(s + " is not a valid FoodType!");
	   }
	   
	   try{
	       t = CraftingMaterialType.valueOf(s.toUpperCase());
	       type = t;
	       return;
	   }catch(Exception e)
	   {
		   //System.err.println(s + " is not a valid CraftingMaterialType!");
	   }
	   
	   try{
	       t = RefinementType.valueOf(s.toUpperCase());
	       type = t;
	       return;
	   }catch(Exception e)
	   {
		   //System.err.println(s + " is not a valid RefinementType!");
	   }
	} else {
		if(t instanceof Object[])
		{
			type = ((Object[])t)[1];
		} else {
			type = t;
		}
	}
>>>>>>> origin/master
    }
    
    /**
     * Returns all ingredients' ids.
     * @return an array of Integer
     */
    public Integer[] getIngredientIDs()
    {
	Set<Integer> keys = ingredients.keySet();
	return keys.toArray(new Integer[keys.size()]);
    }
    
    /**
     * Get the minimum discipline rating.
     * @return
     */
    public int getMinRating()
    {
	return minRating;
    }
    
    public Item getOutputItem()
    {
	return outputItem;
    }
    
    /**
     * Get the amount of the output.
     * @return amount of the output.
     */
    public int getOutputItemCount()
    {
	return outputItemCount;
    }
    
    /**
     * Get the crafted item's id.
     * @return output item id
     */
    public int getOutputItemID()
    {
	return outputItemID;
    }
    
    public String getOutputItemName()
    {
	return outputItemName;
    }
    
    /**
     * Get this recipe's flag.
     * @return
     */
    public RecipeFlag getRecipeFlag()
    {
	return flag;
    }
    
    /**
     * Get the time it takes to craft this recipe in milliseconds.
     * @return time to craft in ms
     */
    public int getTimeToCraftMs()
    {
	return timeToCraftMs;
    }
    
    /**
     * Get this recipe's type.
     * 
     * @return an enum constant.
     */
    public Object getType()
    {
	return type;
    }
    
    /**
     * Set the id.
     * @param id
     */
    public void setID(int id)
    {
	this.id = id;
    }
    
    /**
     * Set the minimum rating.
     * @param minRating
     */
    public void setMinRating(int minRating)
    {
	this.minRating = minRating;
    }
    
    public void setOutputItem(Item outputItem)
    {
	this.outputItem = outputItem;
	outputItemName = outputItem.getName();
    }
    
    /**
     * Set the amount if the crafted item.
     * @param outputItemCount
     */
    public void setOutputItemCount(int outputItemCount)
    {
	this.outputItemCount = outputItemCount;
    }
    
    /**
     * Set the crafted item's id.
     * @param id
     */
    public void setOutputItemID(int id)
    {
	outputItemID = id;
    }
    
    public void setOutputItemName(String outputItemName)
    {
	this.outputItemName = outputItemName;
    }
    
    public void setRecipeFlag(String flag)
    {
    	try{
    		this.flag = RecipeFlag.valueOf(flag.toUpperCase());
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    /**
     * <li>id
     * <li>type
     * <li>output_item_id
     * <li>output_item_count
     * <li>min_rating
     * <li>time_to_craft_ms
     * <li>disciplines
     * <li>flags
     * <li>ingredients <i>an int array, where 0 = id and 1 = count</i>
     * @param prop
     * @param value
     */
    public void setProperty(String prop, Object value)
    {
	switch(prop)
	{
	    case "id":
		id = (int) value;
		break;
	    case "type":
		setType(value.toString());
		break;
	    case "output_item_id":
		outputItemID = (int) value;
		break;
	    case "output_item_count":
		outputItemCount = (int) value;
		break;
	    case "min_rating":
		minRating = (int) value;
	    case "time_to_craft_ms":
		timeToCraftMs = (int) value;
		break;
	    case "disciplines":
		addDiscipline(value.toString());
		break;
	    case "flags":
		setRecipeFlag(value.toString());
		break;
	    case "ingredients":
		int[] ing = (int[]) value;
		addIngredient(ing[0], ing[1]);
		break;
	}
    }
    
    /**
     * Set this recipe's flag.
     * @param flag
     */
    public void setRecipeFlag(RecipeFlag flag)
    {
	this.flag = flag;
    }
    
    public void setRecipeFlag(String flag)
    {
	try {
	    this.flag = RecipeFlag.valueOf(flag.toUpperCase());
	}
	catch(Exception e) {
	    e.printStackTrace();
	}
    }
    
    /**
     * Set the time to craft in milliseconds.
     * @param timeToCraftMs
     */
    public void setTimeToCraftMs(int timeToCraftMs)
    {
	this.timeToCraftMs = timeToCraftMs;
    }
    
    /**
     * Set this recipe's type.
     * @param type
     */
    public void setType(Object type)
    {
	this.type = type;
    }
    
    /**
     * Goes through all Type enums to find the right type.
     * @param s
     */
    public void setType(String s)
    {
<<<<<<< HEAD
	Object t = Type.getType(s);
	if(t == Type.NONE) {
	    try {
		t = FoodType.valueOf(s.toUpperCase());
		type = t;
		return;
	    }
	    catch(Exception e) {
		// System.err.println(s + " is not a valid FoodType!");
	    }
	    
	    try {
		t = CraftingMaterialType.valueOf(s.toUpperCase());
		type = t;
		return;
	    }
	    catch(Exception e) {
		// System.err.println(s +
		// " is not a valid CraftingMaterialType!");
	    }
	    
	    try {
		t = RefinementType.valueOf(s.toUpperCase());
		type = t;
		return;
	    }
	    catch(Exception e) {
		// System.err.println(s + " is not a valid RefinementType!");
	    }
	} else {
	    if(t instanceof Object[]) {
		type = ((Object[]) t )[1];
	    } else {
		type = t;
	    }
	}
    }
    
    @Override
    public String toString()
    {
	StringBuilder b = new StringBuilder();
	b.append("{id:" + id + ",\ntype:" + type + ",\noutput_item_id:" + outputItemID + ",\noutput_item_count:" + outputItemCount + "\noutput_item_name:" + outputItemName + ",\ntime_to_craft_ms:" + timeToCraftMs + ",\ndisciplines:{");
	for(Discipline d : disciplines) {
	    b.append(d + ",");
	}
	b.append("},\nmin_rating:" + minRating + ",\ningredients:{");
	for(int id : ingredients.keySet()) {
	    b.append("{id:" + id + ",count:" + ingredients.get(id) + "},");
	}
	b.append("},\nflag:" + flag + "}");
	return b.toString();
=======
    	Set<Integer> keys= ingredients.keySet();
    	return keys.toArray(new Integer[keys.size()]);
    }
    
    public int getIngredientCount(int id)
    {
    	return ingredients.get(id);
    }
    /**
     * <li>id
     * <li>type
     * <li>output_item_id
     * <li>output_item_count
     * <li>min_rating
     * <li>time_to_craft_ms
     * <li>disciplines
     * <li>flags
     * <li>ingredients <i>an int array, where 0 = id and 1 = count</i>
     * @param prop
     * @param value
     */
    public void setProperty(String prop, Object value)
    {
    	switch(prop)
    	{
    	case "id":
    		id = (int)value;
    		break;
    	case "type":
    		setType(value.toString());
    		break;
    	case "output_item_id":
    		outputItemID = (int)value;
    		break;
    	case "output_item_count":
    		outputItemCount = (int)value;
    		break;
    	case "min_rating":
    		minRating = (int)value;
    	case "time_to_craft_ms":
    		timeToCraftMs = (int)value;
    		break;
    	case "disciplines":
    		addDiscipline(value.toString());
    		break;
    	case "flags":
    		setRecipeFlag(value.toString());
    		break;
    	case "ingredients":
    		int[] ing = (int[])value;
    		addIngredient(ing[0], ing[1]);
    		break;
    	}
    }
    
    @Override
    public String toString(){
    	StringBuilder b = new StringBuilder();
    	b.append("{id:" + id + ",\ntype:"+type+",\noutput_item_id:"+outputItemID+",\noutput_item_count:"+outputItemCount+",\ntime_to_craft_ms:"+timeToCraftMs+",\ndisciplines:{");
    	for(Discipline d : disciplines)
    	{
    		b.append(d+",");
    	}
    	b.append("},\nmin_rating:"+minRating+",\ningredients:{");
    	for(int id : ingredients.keySet())
    	{
    		b.append("{id:"+id+",count:"+ingredients.get(id)+"},");
    	}
    	b.append("},\nflag:"+flag+"}");
    	return b.toString();
>>>>>>> origin/master
    }
}
