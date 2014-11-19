package com.leetcode.problems.array;

/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * Note:
 * You may not engage in multiple transactions at the same time 
 * (ie, you must sell the stock before you buy again).
 * */

public class BuySellStock3 {
	 public int maxProfit(int[] prices) {
	        int maxProfit =0; 
	        if (prices.length<2) return 0;
	        int[] historyProfit = new int[prices.length]; 
	        historyProfit[0] = 0; 
	        int[] futureProfit = new int[prices.length]; 
	        futureProfit[prices.length-1] = 0; 
	        int valley = prices[0]; 
	        int peak = prices[prices.length-1]; 
	        int i=1;
	        while (i<prices.length){
	            valley = Math.min(valley, prices[i]);
	            historyProfit[i] = Math.max(historyProfit[i-1], prices[i]-valley); 
	            i++; 
	        }
	        int profit =0; 
	        i = prices.length-2; 
	        while (i>=0){
	            peak = Math.max(peak, prices[i]); 
	            futureProfit[i] = Math.max(futureProfit[i+1], peak - prices[i]);
	            profit = futureProfit[i] + historyProfit[i]; 
	            if (profit > maxProfit) maxProfit = profit; 
	            i--; 
	        }
	        return maxProfit; 
	    }

}
