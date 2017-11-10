package edu.mandeep.practice.cube;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Pair{
	int a, b;
	
	Pair(int x, int y){
		a = x;
		b = y;
	}
}

public class CubeHashmap {
	public static void main(String arg[]){
		HashMap<Long, ArrayList<Pair>> hashmap = new HashMap<>();
		
		//int n = 100000;
		int n = 1729;
		for(int a = 1; a <= n; a++){
			for(int b = a; b <= n; b++){
				long cube = (long) (Math.pow(a, 3) + Math.pow(b, 3));
				
				if( hashmap.containsKey(cube) ){
					List<Pair> list = hashmap.get(cube);
					for(Pair p : list){
						System.out.println(a + " " + b + " " + p.a+ " "+ p.b);
					}
				}else{
					ArrayList<Pair> list = new ArrayList<>();
					hashmap.put(cube, list);
				}
				
				hashmap.get(cube).add(new Pair(a, b));
			}
		}
	}
}
