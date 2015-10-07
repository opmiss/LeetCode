package java;

import java.util.Set;

public class P139_WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
        boolean[][] canBreak = new boolean[s.length()][s.length()]; 
		  for (int k=0; k<s.length(); k++){
			  for (int i=0; i<s.length()-k; i++){
				  canBreak[i][i+k] = dict.contains(s.substring(i, i+k+1)); 
				  int j=0; 
				  while (!canBreak[i][i+k]&&j<k){
					  canBreak[i][i+k] = canBreak[i][i+j] && canBreak[i+j+1][i+k];
					  j++; 
				  }
			  }
		  }
		  return canBreak[0][s.length()-1]; 
    }

}
