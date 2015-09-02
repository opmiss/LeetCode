package java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P056_Intervals {
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
	/*
	 * Given a collection of intervals, merge all overlapping intervals.
	 * For example,
	 * Given [1,3],[2,6],[8,10],[15,18],
	 * return [1,6],[8,10],[15,18].
	 */
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals.size() < 2)
			return intervals;
		List<Interval> ret = new ArrayList<Interval>();
		Collections.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start-o2.start;
			}
			});
		Interval cur = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval val = intervals.get(i);
			if (cur.end < val.start) {
				ret.add(cur);
				cur = val;
			} else if (cur.start > val.end) {
				ret.add(val);
			} else {
				cur.start = (cur.start<val.start)?cur.start:val.start; 
				cur.end = (cur.end>val.end)?cur.end:val.end;
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
                newInterval.start = (i.start<newInterval.start)?i.start:newInterval.start; 
                newInterval.end = (i.end>newInterval.end)?i.end:newInterval.end;
            }
        }
        ret.add(newInterval); 
        return ret; 
    }

}
