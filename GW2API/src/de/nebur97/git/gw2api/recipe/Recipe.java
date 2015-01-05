package de.nebur97.git.gw2api.recipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

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
public class Recipe implements EntryWithID
{
    private int id;
    private Object type;
    private int outputItemID;
    private int outputItemCount;
    private int timeToCraftMs;
    private List<Discipline> disciplines = new ArrayList<Discipline>();
    private int minRating;
    //ID,Count
    private HashMap<Integer,Integer> ingredients = new HashMap<Integer,Integer>();
    private RecipeFlag flag;
    
    /**
     * Get this recipe's id.
     * @return the id
     */
    @Override
    public int getID()
    {
	return id;
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
     * Get this recipe's type.
     * 
     * @return an enum constant.
     */
    public Object getType()
    {
	return type;
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
	Object t = Type.getSuperType(s);
	if(t == Type.NONE)
	{
	   try{
	       t = FoodType.valueOf(s.toUpperCase());
	       type = t;
	       return;
	   }catch(Exception e)
	   {
	       e.printStackTrace();
	   }
	   
	   try{
	       t = CraftingMaterialType.valueOf(s.toUpperCase());
	       type = t;
	       return;
	   }catch(Exception e)
	   {
	       e.printStackTrace();
	   }
	   
	   try{
	       t = RefinementType.valueOf(s.toUpperCase());
	       type = t;
	       return;
	   }catch(Exception e)
	   {
	       e.printStackTrace();
	   }
	} else {
	    t = ((Type)t).getSubType(s);
	    type = t;
	}
    }
    
    /**
     * Get the crafted item's id.
     * @return output item id
     */
    public int getOutputItemID()
    {
	return outputItemID;
    }
    
    /**
     * Set the crafted item's id.
     * @param id
     */
    public void setOutputItemID(int id)
    {
	outputItemID = id;
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
     * Set the amount if the crafted item.
     * @param outputItemCount
     */
    public void setOutputItemCount(int outputItemCount)
    {
        this.outputItemCount = outputItemCount;
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
     * Set the time to craft in milliseconds.
     * @param timeToCraftMs
     */
    public void setTimeToCraftMs(int timeToCraftMs)
    {
        this.timeToCraftMs = timeToCraftMs;
    }

    /**
     * Get the minimum discipline rating.
     * @return
     */
    public int getMinRating()
    {
        return minRating;
    }

    /**
     * Set the minimum rating.
     * @param minRating
     */
    public void setMinRating(int minRating)
    {
        this.minRating = minRating;
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
     * Set this recipe's flag.
     * @param flag
     */
    public void setRecipeFlag(RecipeFlag flag)
    {
        this.flag = flag;
    }
    
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
     * Gets an array of all discplines added to this recipes.
     * @return array of disciplines
     */
    public Discipline[] getDisciplines()
    {
	return disciplines.toArray(new Discipline[disciplines.size()]);
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
     * Returns all ingredients' ids.
     * @return an array of Integer
     */
    public Integer[] getIngredientIDs()
    {
	Set<Integer> keys= ingredients.keySet();
	return keys.toArray(new Integer[keys.size()]);
    }
}
