package de.nebur97.git.gw2api.manager;

import java.util.List;

/**
 * @author NeBuR97
 **/
interface Manager<T>
{

    public T get(T obj);

    public List<T> getList();

    public void add(T obj);

    public boolean isLoaded(T obj);
}
