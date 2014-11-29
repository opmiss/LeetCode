package com.leetcode.problems.dp;

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

public class DistinctSubsequences {
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

}
