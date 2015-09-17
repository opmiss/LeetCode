package Java;

public class P121_BuySellStock {
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
	public int maxProfit(int k, int[] prices) {
        if (k>prices.length/2) k = prices.length/2; //can be replaced by a quick solve routine
        if (k==0) return 0; 
         int[] profit = new int[k*2+2]; 
		 for (int v=0; v<=k; v++) profit[v*2] = Integer.MIN_VALUE; 
		 for (int p:prices){
			 for (int v=k; v>0; v--){
				 int i=v*2; 
				 profit[i+1] = max(profit[i+1], p+profit[i]); 
				 profit[i] = max(profit[i], profit[i-1]-p); 
			 }
		 }
		 return profit[k*2+1]; 
	}
}
