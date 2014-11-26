package com.leetcode.problems.hashtable;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * You are given a string, S, and a list of words, L, that are all of the same length. 
 *
 * Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * 
 * You should return the indices: [0,9].
 * 
 * (order does not matter).
 * 
 */

public class ConcatenationAllWords {
	HashMap<String, Integer> dict;
	int num;
	int step;

	public void InitializeVar(String[] L) {
		dict = new HashMap<String, Integer>();
		for (String l : L) {
			Integer k = dict.get(l);
			if (k == null)
				dict.put(l, 1);
			else
				dict.put(l, (k + 1));
		}
		num = L.length;
		step = L[0].length();
	}

	public ArrayList<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		if (S.length() == 0)
			return ret;
		if (L.length == 0)
			return ret;
		InitializeVar(L);
		int i = 0, j = 0;
		int sublength = step * num;
		HashMap<String, Integer> seen = new HashMap<String, Integer>();
		while (i <= S.length() - sublength) {
			j = 0;
			if (dict.containsKey(S.substring(i, i + step))) {
				String subS = S.substring(i, (i + sublength));
				seen.clear();
				while (j < num) {
					int start = j * step;
					String word = subS.substring(start, start + step);
					if (!dict.containsKey(word))
						break;
					else {
						Integer k = seen.get(word);
						if (k == null)
							seen.put(word, 1);
						else {
							if (k >= dict.get(word))
								break;
							else
								seen.put(word, (k + 1));
						}
					}
					j++;
				}
			}
			if (j == num)
				ret.add(i);
			i++;
		}
		return ret;
	}
}
