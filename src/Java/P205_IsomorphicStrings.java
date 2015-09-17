package Java;

import java.util.*; 

public class P205_IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length())
			return false;
		Map<Character, Character> map = new HashMap<Character, Character>();
		for (int i = 0; i < s.length(); i++) {
			Character c = map.get(s.charAt(i));
			if (c == null) {
				map.put(s.charAt(i), t.charAt(i));
			} else if (c != t.charAt(i))
				return false;
		}
		Set<Character> set = new HashSet<Character>();
		for (Character v : map.values()) {
			if (!set.add(v))
				return false;
		}
		return true;
	}
}
