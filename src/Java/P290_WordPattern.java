package Java;
import java.util.*;

public class P290_WordPattern {
	public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<Character, String>();
        String[] words = str.split(" ");
        if (pattern.length()!=words.length) return false; 
        for (int i=0; i<pattern.length(); i++){
            Character ch = pattern.charAt(i);
            String word = map.get(ch);
            if (word==null) map.put(ch, words[i]); 
            else if (!word.equals(words[i])) return false; 
        }
        Set<String> set = new HashSet<String>(); 
        for (Character ch:map.keySet()){
            if (!set.add(map.get(ch))) return false; 
        }
        return true; 
    }
}
