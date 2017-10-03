/**
 * 
 */
package edu.mandeep.interviewprep;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * LRU Cache Implementation using LinkedHashMap
 * @author mandeep
 */

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static float loadFactor = 0.75f;
	private static LRUCache<String, String> cache;
	int size;
	
	public LRUCache(int size){
		super(size, loadFactor, true);
		this.size = size;
	}
	
	private static LRUCache<String, String> getInstance(int size){
		return new LRUCache<String, String>(size);
	}
	
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest){
		return size() > size;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		cache = LRUCache.getInstance(3);
		cache.put("1", "A");
		cache.put("2", "B");
		cache.put("3", "C");
		cache.get("1");
		cache.put("4", "D");
		System.out.println(cache);
		cache.get("3");
		cache.put("5", "E");
		System.out.println(cache);
	}
}