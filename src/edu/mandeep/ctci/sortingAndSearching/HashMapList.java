/**
 * 
 */
package edu.mandeep.ctci.sortingAndSearching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * @author mandeep
 *
 */
public class HashMapList<T, E> {

	private HashMap<T, ArrayList<E>> map = new HashMap<T, ArrayList<E>>();
	
	//insert item into list at key
	public void put(T key, E item){
		if(!map.containsKey(key))
			map.put(key, new ArrayList<E>());
		map.get(key).add(item);
	}
	
	//insert list of items at key
	public void put(T key, ArrayList<E> items){
		map.put(key, items);
	}
	
	//get list of items at key
	public ArrayList<E> get(T key){
		return map.get(key);
	}
	
	//if hashmaplist contains key
	public boolean containsKey(T key){
		return map.containsKey(key);
	}
	
	//if list at key contains value
	public boolean containsKeyValue(T key, E value){
		ArrayList<E> list = get(key);
		if(list == null)
			return false;
		return list.contains(value);
	}
	
	//Get list of keys
	public Set<T> keySet(){
		return map.keySet();
	}
	
	@Override
	public String toString(){
		return map.toString();
	}
}