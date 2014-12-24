package com.leetcode.problems.hashtable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

public class AllWords {

	public ArrayList<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		Map<String, Integer> dict = new HashMap<String, Integer>();
		for (String l : L) {
			Integer k = dict.get(l);
			if (k == null) k=0; 
			dict.put(l, (k + 1));
		}
		int num = L.length;
		int step = L[0].length();
		int i = 0, start;
		int sublength = step * num;
		HashMap<String, Integer> seen = new HashMap<String, Integer>();
		while (i <= S.length() - sublength) {
			if (dict.containsKey(S.substring(i, i + step))) {
				start = i;
				seen.clear();
				while (start-i < sublength) {
					String word = S.substring(start, start + step);
					Integer m = dict.get(word);
					if (m == null) break; 
					Integer k = seen.get(word);
					if (k == null) k=0;
					++k; 
					if (k >m) break;
					seen.put(word, k);
					start+=step;
				}
				if (start-i == sublength) ret.add(i);
			}
			i++;
		}
		return ret;
	}
	public static void main(String[] args){
		String S = "barfoothefoobarman"; 
		String[] L = new String[]{"foo", "bar"};  
		AllWords aw = new AllWords(); 
		System.out.println(aw.findSubstring(S, L)); 
		
	}
}
