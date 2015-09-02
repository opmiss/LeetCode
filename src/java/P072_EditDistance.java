package java;

/*
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. 
 * (each operation is counted as 1 step.)
 * You have the following 3 operations permitted on a word:
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 */
public class P072_EditDistance {
	public int minDistance(String word1, String word2) {
    	int l1 = word1.length(); 
    	int l2 = word2.length(); 
    	int[] p0 = new int[l2+1]; 
    	for (int i=0; i<p0.length; i++) p0[i]=i; 
    	int[] p1 = new int[l2+1]; 
    	for (int i1=0; i1<l1; i1++){
    		p1[0] = i1+1;
    		for (int i2=0; i2<l2; i2++){
    			p1[i2+1] = (p1[i2] < p0[i2+1])? (p1[i2]+1):(p0[i2+1]+1); 
    			if (word1.charAt(i1)==word2.charAt(i2))
    				p1[i2+1] = (p1[i2+1]<p0[i2])?p1[i2+1]:p0[i2];
    			else 
    				p1[i2+1] = (p1[i2+1]<p0[i2]+1)?p1[i2+1]:(p0[i2]+1);
    		}
    		for (int i=0; i<=l2; i++) p0[i] = p1[i]; 
    	}
        return p0[l2]; 
    }

}
