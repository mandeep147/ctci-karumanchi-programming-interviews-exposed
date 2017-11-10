/**
 * 
 */
package edu.mandeep.practice;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Given n points on a 2D plane,
 * find a straight line that can fit as my points as possible. 
 * Return, the maximum number of points you can fit.  
 * Input : points[] = {-1, 1}, {0, 0}, {1, 1}, 
 * 					{2, 2}, {3, 3}, {3, 4} 
 * Output : 4
 * @author mandeep
 */
public class MaxPointsOnLine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> x = new ArrayList<Integer>();
		ArrayList<Integer> y = new ArrayList<Integer>();
		
		x.add(-1);
		x.add(0);
		x.add(1);
		x.add(2);
		x.add(3);
		x.add(3);
		
		y.add(1);
		y.add(0);
		y.add(1);
		y.add(2);
		y.add(3);
		y.add(4);
		System.out.println(maxPointsOnLine(x, y));
	}
	
	private static int maxPointsOnLine(ArrayList<Integer> x, ArrayList<Integer>y){
		int max = 0;
		HashMap<Double, Integer> map = new HashMap<Double, Integer>();
		
		if(x.size() != y.size() || x.size() == 0 || y.size() == 0 || x == null || y == null)
			return max;
		
		if(x.size() == 1 && y.size() == 1)
			return 1;
		
		for(int i = 0; i < x.size(); i++){
			int duplicate = 1;
			int vertical = 0;
			int xi = x.get(i);
			int yi = y.get(i);
			
			for(int j = i + 1; j < x.size(); j++){
				int xj = x.get(j);
				int yj = y.get(j);
				
				if(xi == xj){
					if(yi == yj)
						duplicate++;
					else vertical++;
				}else{
					double slope = 0.0;
					if(yj - yi == 0)
						slope = 0.0;
					else if(xj - xi == 0)
						slope = Double.MAX_VALUE;
					else 
						slope = (double)(yj - yi)/(double)(xj - xi);
					
					if(map.containsKey(slope))
						map.put(slope, map.get(slope) + 1);
					else
						map.put(slope, 1);
				}
			}
			
			for(int ele : map.values())
				if(max < ele + duplicate)
					max = ele + duplicate;
			
			max = Math.max(vertical + duplicate,  max);
			map.clear();
		}
		
		return max;
	}
}