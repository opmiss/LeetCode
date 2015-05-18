package com.leetcode.algorithms;

public class P164_MaximumGap {
	class Bucket {
		int min;
		int max;

		Bucket(int val) {
			max = min = val;
		}

		void add(int n) {
			max = (max < n) ? n : max;
			min = (min > n) ? n : min;
		}
	}

	public int maximumGap(int[] num) {
		if (num.length < 2)
			return 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int n : num) {
			max = (max < n) ? n : max;
			min = (min > n) ? n : min;
		}
		double step = (double)(max - min) / (num.length - 1);
		Bucket[] buckets = new Bucket[num.length];
		for (int n : num) {
			int id = (int)((n - min) / step);
			if (buckets[id] == null)
				buckets[id] = new Bucket(n);
			else
				buckets[id].add(n);
		}
		int gap = (int) step;
		int prev = buckets[0].max;
		for (int i=1; i<num.length; i++) {
			Bucket b = buckets[i]; 
			if (b!=null){
				int t = b.min - prev;
				gap = (gap > t) ? gap : t;
				prev = b.max;
			}
		}
		return gap;
	}

}
