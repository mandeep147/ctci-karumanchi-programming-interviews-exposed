/**
 * Given an array of hashmaps, and a single hashmap, find all those having elements of given hashmap
 */
package edu.mandeep.practice;

import java.util.*;

/**
 * @author mandeep
 *
 */
public class HashMapIntersection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("a", "1");
		map.put("b", "2");
		List<Map<String, String>> list = new ArrayList<>();
		HashMap<String, String> map0 = new HashMap<>();
		HashMap<String, String> map1 = new HashMap<>();
		HashMap<String, String> map2 = new HashMap<>();
		HashMap<String, String> map3 = new HashMap<>();

		map0.put("a", "1");
		map0.put("b", "2");
		map0.put("c", "3");

		map1.put("a", "1");
		map1.put("b", "3");

		map2.put("a", "1");
		map2.put("b", "2");
		map2.put("c", "3");
		map2.put("d", "4");

		map3.put("a", "1");
		map3.put("c", "3");

		list.add(map0);
		list.add(map1);
		list.add(map2);
		list.add(map3);

		@SuppressWarnings("unchecked")
		HashMap<String, String>[] input = new HashMap[4];
		input[0] = map0;
		input[1] = map1;
		input[2] = map2;
		input[3] = map3;

		findIntersection(map, input);
		getIntersection(map, input);
	}

	private static void findIntersection(HashMap<String, String> map, HashMap<String, String>[] input) {
		int i1 = 0;
		for (int i = 0; i < input.length; i++) {
			HashMap<String, String> curr = input[i];
			if (curr.keySet().size() >= map.keySet().size()) {
				for (Object key : map.keySet()) {
					if (curr.containsKey(key)) {
						i1++;
					}
				}
				if (i1 >= map.size()){
					boolean flag = false;
					for (String s : map.keySet()) {
						if (map.get(s).equals(curr.get(s))) {
							flag = true;
						} else
							flag = false;
					}
					if (flag)
						// finallist.add(intersect);
						System.out.println(curr);
				}
			}
		}
	}

	private static void getIntersection(HashMap<String, String> map, HashMap<String, String>[] input){
		Set<String> result = new HashSet<>(map.keySet());
		boolean flag = false;
		for(int i = 0; i < input.length; i++){;
			result.retainAll(input[i].keySet());
			if(result.size() == map.size()){
				for (String s : map.keySet()) {
					if (map.get(s).equals(input[i].get(s))) {
						flag = true;
					} else
						flag = false;
				}
				if (flag)
					System.out.println(input[i]);
			}else{
				//do nothing
			}
		}
	}
}