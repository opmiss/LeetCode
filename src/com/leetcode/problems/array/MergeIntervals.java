package com.leetcode.problems.array;

import java.util.Vector;
import java.util.Collections;
import java.util.Comparator;

/*
 * Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 * */


public class MergeIntervals {

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

}
