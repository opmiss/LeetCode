package com.leetcode.problems.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Permutations {
	
	/*
	 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
	 * For example,
	 * [1,1,2] have the following unique permutations:
	 * [1,1,2], [1,2,1], and [2,1,1].
	 * 
	 */
    
    public List<List<Integer>> permuteUnique(int[] num) {
    	Arrays.sort(num);
      	ArrayList<Integer> list = new ArrayList<Integer>(); 
    	for (int n:num) list.add(n); 
    	return permute(list); 
    }
    
    private List<List<Integer>> permute(ArrayList<Integer> list){
    	List<List<Integer>> ret = new ArrayList<List<Integer>>(); 
    	if (list.size()<=1) {
    		ret.add(new ArrayList<Integer>(list)); 
    		return ret; 
    	}
    	for (int i=0; i<list.size(); i++){
            if (i>0 && list.get(i)==list.get(i-1)) {
            	continue; 
            }
    		int e = list.remove(i); 
    		List<List<Integer>> p = permute(list); 
    		for (List<Integer> l:p){
    			l.add(e); 
    			ret.add(l); 
    		}
    		list.add(i, e); 
    	}
    	return ret; 
    }
    
    public void test(){
    	int[] input = new int[]{-1, -1, 3, -1}; 
    	System.out.println(permuteUnique(input)); 
    }
    /*
     * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
     * If such arrangement is not possible, it must rearrange it as the lowest possible order 
     * (ie, sorted in ascending order).
     * The replacement must be in-place, do not allocate extra memory.
     * Here are some examples. 
     * Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
     * 1,2,3 -> 1,3,2
     * 3,2,1 -> 1,2,3
     * 1,1,5 -> 1,5,1
     * 
    */
	public void nextPermutation(int[] num) {
		int n = num.length;
		if (n <= 1)
			return;
		int i = n - 1;
		//find the first increasing element from right to left
		while (i >= 1) {
			if (num[i - 1] < num[i])
				break;
			i--;
		}
		//if the whole array is decreasing/lexicographically greatest, reverse the array
		if (i == 0) {
			int s = 0;
			int e = n - 1;
			while (s < e) {
				swap(num, s, e);
				s++;
				e--;
			}
			return;
		}
		//find the element in the decreasing chain greater than the first increasing element, and swap them
		int m = i;
		int p = i - 1;
		for (i = n - 1; i >= m; i--) {
			if (num[i] > num[p])
				break;
		}
		int h = i;
		swap(num, p, h);
		//reverse the decreasing chain into increasing
		int s = m;
		int e = n - 1;
		while (s < e) {
			swap(num, s, e);
			s++;
			e--;
		}
	}

	private void swap(int[] num, int i, int j) {
		int t = num[i];
		num[i] = num[j];
		num[j] = t;
	}
	private String toString(int[] num){
		StringBuffer sb = new StringBuffer(); 
		for (int n:num){
			sb.append(Character.forDigit(n, 10)); 
		}
		return sb.toString(); 
	}
	
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
	
	public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> ret = new ArrayList<String>(); 
        if (n==0) {
            ret.add(""); return ret;
        }
        if (n==1) {
            ret.add("()"); return ret;  
        }
        for (int i=0; i<n; i++){
            for (String inner: generateParenthesis(i)){
                for (String outter:generateParenthesis(n-i-1)){
                    ret.add("("+inner+")"+outter); 
                }
            }
        }
        return ret; 
    }
	
	
	public static void main(String[] args){
		Permutations p = new Permutations(); 
		System.out.println(p.generateParenthesis(4)); 
	}
	
}
