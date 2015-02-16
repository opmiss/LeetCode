package com.leetcode.problems.dp;

/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * Note:
 * You may not engage in multiple transactions at the same time 
 * (ie, you must sell the stock before you buy again).
 * */

public class BuySellStock {
	/*
	 * Say you have an array for which the ith element is the price of a given stock on day i.
	 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
	 * Note:
	 * You may not engage in multiple transactions at the same time 
	 * (ie, you must sell the stock before you buy again).
	 * */
	 
	public int max(int a, int b){
		return (a>b)?a:b; 
	}
	 public int maxProfit2(int[] prices) {
		 int buy1 = Integer.MIN_VALUE, sell1 =0, buy2 = Integer.MIN_VALUE, sell2=0; 
		 for (int p:prices){
			 sell2 = max(sell2, p+buy2); 
			 buy2 = max(buy2, sell1-p);
			 sell1 = max(sell1, p+buy1);
			 buy1 = max(buy1, -p); 
		 }
		 return sell2; 
	 }
	 
	 /* solution to the problem generalized to K transactions*/ 
	 public int maxProfitK(int[] prices, int K){
		 int[] profit = new int[K*2]; 
		 for (int k=0; k<K; k++) profit[k*2] = Integer.MIN_VALUE; 
		 for (int p:prices){
			 for (int k=K-1; k>=0; k--){
				 int i=k*2; 
				 profit[i+1] = max(profit[i+1], p+profit[i]); 
				 if (i==0) profit[i] = max(profit[i], 0-p); 
				 else profit[i] = max(profit[i], profit[i-1]-p); 
			 }
		 }
		 return profit[K*2-1]; 
	 }
	 
	 public void test(){
		 int[] A = new int[]{1, 2, 0, 5, 2, 3, 4}; 
		 System.out.println(maxProfit2(A)); 
		 System.out.println(maxProfitK(A, 3)); 
	 }
	 
	 public static void main(String[] args){
		 BuySellStock bss = new BuySellStock(); 
		 bss.test(); 
	 }

}
