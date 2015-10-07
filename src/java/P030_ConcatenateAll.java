package java;
import java.util.*; 
/*
 * You are given a string, s, and a list of words, words, that are all of the same length. 
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 * You should return the indices: [0,9].
 * (order does not matter).
 */ 

public class P030_ConcatenateAll {
	
	public List<Integer> findSubstring(String s, String[] words) {
		Map<String, Integer> required = new HashMap<String, Integer>(); 
		for (String w:words) {
			if (required.get(w)==null) required.put(w, 0); 
			required.put(w, required.get(w)+1); 
		}
		int step = words[0].length(); 
		int total = words.length*step;
		List<Integer> res = new ArrayList<Integer>(); 
		int i =0, start; 
		HashMap<String, Integer> seen = new HashMap<String, Integer>(); 
		while (i <= s.length() - total){
			if (required.containsKey(s.substring(i, i+step))){
				seen.clear(); 
				for (start=i; start-i<total; start+=step){
					String word = s.substring(start, start+step); 
					Integer r = required.get(word); 
					if (r==null) break; 
					if (seen.get(word)==null) seen.put(word, 1); 
					else {
						if (seen.get(word)>=r) break; 
						seen.put(word, seen.get(word)+1); 
					}
				}
				if (start-i==total) res.add(i); 
			}
			i++; 
		}
        return res; 
    }
	
	

}
