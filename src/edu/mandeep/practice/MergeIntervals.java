/**
 * IntervieBit
 */
package edu.mandeep.practice;

import java.util.ArrayList;

/**
 * @author mandeep
 *
 */
public class MergeIntervals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//[1,2],[3,5],[6,7],[8,10],[12,16]
		ArrayList<Interval> x = new ArrayList<Interval>();
//	    Interval i1 = new Interval(1,2);
//	    Interval i2 = new Interval(3,5);
//	    Interval i3 = new Interval(6,7);
//	    Interval i4 = new Interval(8,10);
//	    Interval i5 = new Interval(12,16);
//	    Interval i6 = new Interval(4,9);
		Interval i1 = new Interval();
		Interval i2 = new Interval(1,1);
	    x.add(i1);//x.add(i2);x.add(i3);x.add(i4);x.add(i5);

	    ArrayList<Interval> r = insert(x, i2);
	    
	    for(Interval i : r)
	    {
	        System.out.println(i.start+" "+i.end);
	    }
	}

	public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> result = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (interval.end < newInterval.start) {
                result.add(interval);
            } else if (newInterval.end < interval.start) {
                // newInterval   interval
                // [      ]    |
                //             | [      ]
                result.add(newInterval);
                result.addAll(intervals.subList(i, intervals.size()));
                return result;
            } else {
                // overlapping, enlarge newInterval to merge overlapping intervals
                int start = Math.min(newInterval.start, interval.start);
                int end = Math.max(newInterval.end, interval.end);
                newInterval.start = start;
                newInterval.end = end;
            }
        }
        result.add(newInterval);
        return result;
    }
}

class Interval {
	 int start;
	 int end;
	 Interval() { start = 0; end = 0; }
	 Interval(int s, int e) { start = s; end = e; }
}