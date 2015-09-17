package Java;

import java.util.*;

public class P202_HappyNumber {
	 public boolean isHappy(int n) {
	        Set<Integer> exist = new HashSet<Integer>(); 
	        while (n!=1){
	            if (!exist.add(n)) return false; 
	            n = squareDigitSum(n); 
	        }
	        return true; 
	    }
	    public int squareDigitSum(int n){
	        int sum =0; 
	        while (n>0){
	            int d = n%10; 
	            sum+=d*d; 
	            n=n/10; 
	        }
	        return sum; 
	    }

}
