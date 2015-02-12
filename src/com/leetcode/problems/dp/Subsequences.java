package com.leetcode.problems.dp;


public class Subsequences {
	/* 
	 * Given a string S and a string T, 
	 * count the number of distinct subsequences of T in S.
	 * A subsequence of a string is a new string which is formed from the original string by 
	 * deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. 
	 * (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
	 * Here is an example: 
	 * S = "rabbbit", T = "rabbit"
	 * Return 3.
	 * 
	 */
	 public int numDistinct(String S, String T) {
		 if (S.length()<T.length()) return 0; 
		 
		 int[] dp = new int[T.length()+1];
		 dp[0]=1; 
		 for (int i=0; i<S.length(); i++){
			 //must from the end of T
			 for (int j=T.length(); j>0; j++){
				 if (S.charAt(i)==T.charAt(j))
					 dp[j+1]+=dp[j]; 
			 }
		 }
		 return dp[T.length()]; 
	 }
	 /* find a subsequence of a given sequence in which the subsequence's elements are in sorted order, lowest to highest, 
	  * and in which the subsequence is as long as possible.
	  */
	 public int longestIncreasing(int[] X){
		 int[] M = new int[X.length+1];
		 int L =0; 
		 for (int i=0; i<X.length; i++){
			 int lo=1; 
			 int hi=L; 
			 while (lo<=hi){
				 int mid = (int)Math.ceil((lo+hi)/2.0);
				 if (X[M[mid]] < X[i]) lo = mid+1; 
				 else hi=mid-1; 
			 }
			 M[lo] = i; 
			 L = (lo>L)?lo:L; 
		 }
		 return L; 
	 }
	 
	 public void test(){
		 int[] X = new int[]{1, 2, 3, 3, 2, 4};
		 System.out.println(longestIncreasing(X)); 
	 }
	 
	 public static void main(String[] args){
		 Subsequences s = new Subsequences(); 
		 s.test(); 
	 }

}
