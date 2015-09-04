package java;

import java.util.HashMap;

public class P060_PermutationSequence {
	/*
	 * The set [1,2,3,...,n] contains a total of n! unique permutations.
	 * By listing and labeling all of the permutations in order,
	 * We get the following sequence (ie, for n = 3):
	 * 1. "123"
	 * 2. "132"
	 * 3. "213"
	 * 4. "231"
	 * 5. "312"
	 * 6. "321"
	 * Given n and k, return the kth permutation sequence.
	 * Note: Given n will be between 1 and 9 inclusive.
	 */
	
	HashMap<Integer, Integer> factMap= new HashMap<>(); 
	
	private int getFact(int i){
		if (i<=2) return i; 
		if (null==factMap.get(i)){
			factMap.put(i, getFact(i-1)*i); 
		}
		return factMap.get(i); 
	}
	
	public String getPermutation(int n, int k) {
		StringBuffer sb = new StringBuffer(); 
		for (int i=0; i<n; i++) sb.append(Character.forDigit(i+1, 10)); 
		return get(sb, k).toString(); 
	}
	
	private StringBuffer get(StringBuffer sb, int k){
		if (sb.length()==1) return sb; 
		int size = getFact(sb.length()-1); 
		int index = (k-1)/size;
		char c = sb.charAt(index); 
		sb = sb.deleteCharAt(index);
		StringBuffer b = get(sb, k-index*size);
		return b.insert(0, c); 
	}

}
