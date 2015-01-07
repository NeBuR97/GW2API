package de.nebur97.git.gw2api.manager.recipe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import de.nebur97.git.gw2api.manager.Manager;
import de.nebur97.git.gw2api.net.RecipeLoader;
import de.nebur97.git.gw2api.recipe.Recipe;

public class RecipeManager extends Manager<Recipe> {
	private HashMap<Integer,Recipe> outIDMap = new HashMap<Integer,Recipe>();
	private int idsToLoad;
	private List<Integer> ids = new ArrayList<Integer>();
	@Override
	public void add(Recipe r)
	{
		super.add(r);
		outIDMap.put(r.getOutputItemID(), r);
	}
	
	public Recipe getRecipeViaOutputOD(int outputItemID)
	{
		return outIDMap.get(outputItemID);
	}
	@Override
	public void load(Collection<Integer> idsTOLoad) {
		isLoading = true;
		finishedThreads = 0;
		ids.removeAll(ids);
		for(int id : idsTOLoad)
		{
			if(!isLoaded(id))
			{
				ids.add(id);
			}
		}
		idsToLoad = ids.size();
		neededThreads = (idsToLoad < threadCount) ? idsToLoad : threadCount;
		List<List<Integer>> sub = new ArrayList<List<Integer>>();
		for(int a = 0; a < neededThreads; a++)
		{
		    sub.add(new ArrayList<Integer>());
		}
		
		int index = 0;
		System.out.println(sub.size());
		for(int id : ids)
		{
		    if(!isLoaded(id))
		    {
			 sub.get(index).add(id);
			 index++;
		    }
		    if(index == neededThreads)
		    {
			index = 0;
		    }
		}
		
		for(List<Integer> l : sub)
		{
		    executeThread(new RecipeLoader(this,l));
		}
	}

	/*@Override
	public boolean isLoading() {
		synchronized(entryIDs){
		    return entryIDs.size() < idsToLoad;
		}
		return isLoading;
	}*/
	
	public String getProgress()
    {
	return entryIDs.size()+"/"+idsToLoad;
    }

}
