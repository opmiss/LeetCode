package java;

public class P188_BestTimetoBuyandSellStock4 {
	int max(int a, int b){
		return (a>b)?a:b; 
	}
    public int maxProfit(int k, int[] prices) {
        if (k>prices.length/2) return quickSolve(prices); 
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
    
    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }

}
