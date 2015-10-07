package java;
import java.util.*;

public class P003_LongestWithoutRepeat {
	HashMap<Character, Integer> map; 
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==1) return 1; 
        map = new HashMap<Character, Integer>(); 
        int start = 0; 
        int v = 0; 
        int maxlength = 0; 
        while (v<s.length()){
            Integer p = map.get(s.charAt(v)); 
            if (p==null) {
                map.put(s.charAt(v), v); 
            }
            else {
                maxlength = Math.max(maxlength, v-start); 
                for (int i=start; i<=p; i++){
                    map.remove(s.charAt(i)); 
                }
                start = p+1; 
                map.put(s.charAt(v), v); 
            }
            v++; 
        }
        maxlength = Math.max(maxlength, v-start); 
        return maxlength; 
    }

}
