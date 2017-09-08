/**
 * 
 */
package edu.mandeep.interview;

import java.util.Random;

/**
 * 
 * @author mandeep
 *
 */
public class HitCounter implements Comparable<HitCounter> {

	private final String name;
	private final int max;
	private int count;
	
	/**
	 * create a new counter
	 * @param id
	 * @param max
	 */
	public HitCounter(String id, int max){
		name = id;
		this.max = max;
		count = 0;
	}
	
	
	/**
	 * increment counter by 1
	 */
	public void increment(){
		if(count < max)
			count++;
	}
	
	/**
	 * return the value of current count
	 * @return
	 */
	public int currentCount(){
		return count;
	}
	
	public String toString(){
		return name +" : "+ count;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(HitCounter o) {
		if(this.count < o.count)
			return -1;
		else if(this.count > o.count)
			return 1;
		return 0;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int numberOfCounters = 6;
		int trials = 600000;
		
		HitCounter[] hits = new HitCounter[numberOfCounters];
		for(int i = 0; i < numberOfCounters; i++)
			hits[i] = new HitCounter(i + " ", trials);
		
		for(int i = 0; i < trials; i++){
			int index = new Random().nextInt(numberOfCounters);
			hits[index].increment();
		}
		
		for(int i = 0; i < numberOfCounters; i++)
			System.out.println(hits[i]);
	}

}