package java;

public class P242_ValidAnagram {
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		int[] table = new int[26];
		for (int i = 0; i < s.length(); i++) {
			table[s.charAt(i) - 'a']++;
			table[t.charAt(i) - 'a']--;
		}
		for (int i = 0; i < s.length(); i++) {
			if (table[s.charAt(i) - 'a'] != 0)
				return false;
			if (table[t.charAt(i) - 'a'] != 0)
				return false;
		}
		return true;
	}
}
