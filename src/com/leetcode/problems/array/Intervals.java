package com.leetcode.problems.array;

import java.util.ArrayList;
import java.util.Vector;
import java.util.Collections;
import java.util.Comparator;

public class Intervals {

	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public class IntervalComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval i1, Interval i2) {
			if (i1.start > i2.start)
				return 1;
			else if (i1.start < i2.start)
				return -1;
			else {
				if (i1.end > i2.end)
					return 1;
				else if (i1.end < i2.end)
					return -1;
				else
					return 0;
			}
		}
	}
	
	/*
	 * Given a collection of intervals, merge all overlapping intervals.
	 * For example,
	 * Given [1,3],[2,6],[8,10],[15,18],
	 * return [1,6],[8,10],[15,18].
	 * */

	public Vector<Interval> merge(Vector<Interval> intervals) {
		if (intervals.size() < 2)
			return intervals;
		Vector<Interval> ret = new Vector<Interval>();
		IntervalComparator c = new IntervalComparator();
		Collections.sort(intervals, c);
		Interval cur = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval val = intervals.get(i);
			if (cur.end < val.start) {
				ret.add(cur);
				cur = val;
			} else if (cur.start > val.end) {
				ret.add(val);
			} else {
				cur = new Interval(Math.min(cur.start, val.start), Math.max(
						cur.end, val.end));
			}
		}
		ret.add(cur);
		return ret;
	}
	
	/*
	 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
	 * You may assume that the intervals were initially sorted according to their start times.
	 * Example 1:
	 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
	 * Example 2:
	 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
	 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
	 * */
	
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> ret = new ArrayList<Interval>(); 
        if (intervals.size()==0) { ret.add(newInterval); return ret; }
        for (Interval i: intervals){
            if (i.end < newInterval.start) ret.add(i);
            else if (i.start > newInterval.end) {ret.add(newInterval); newInterval=i; }
            else {
                Interval m = new Interval(Math.min(i.start, newInterval.start), Math.max(i.end, newInterval.end));
                newInterval = m; 
            }
        }
        ret.add(newInterval); 
        return ret; 
    }

}
