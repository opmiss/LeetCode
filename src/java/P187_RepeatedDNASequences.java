package java;
import java.util.*; 

public class P187_RepeatedDNASequences {
	int gethash(char c){
		switch(c){
		case 'A':
			return 0; 
		case 'C':
			return 1; 
		case 'G':
			return 2; 
		}
		return 3; 
	}
	
    public List<String> findRepeatedDnaSequences(String s) {
    	Set<Integer> seen = new HashSet<Integer>(); 
    	int h = 0; 
    	Set<String> res = new HashSet<String>(); 
    	for (int i=0; i<s.length(); i++){
    		h = ((h<<2)|gethash(s.charAt(i)))&0x000FFFFF;
    		if (i>8&&!seen.add(h)) res.add(s.substring(i-9, i+1)); 
    	}
        return new ArrayList<>(res); 
    }

}
