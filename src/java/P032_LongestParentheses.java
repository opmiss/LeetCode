package java;
import java.util.*;

public class P032_LongestParentheses {
	 public int longestValidParentheses(String s) {
	        if (s.length()<2) return 0; 
	        boolean[] mask = new boolean[s.length()]; 
	        Stack<Integer> stack = new Stack<Integer>(); 
	        int i=0; 
	        while (i<s.length()){
	            if (s.charAt(i) == ')'){
	                if (!stack.isEmpty()){
	                    Integer k = stack.pop(); 
	                    mask[i]=mask[k]=true; 
	                }
	            }
	            else stack.push(i); 
	            i++; 
	        }
	        int l =0;
	        int maxl=0; 
	        boolean count = false; 
	        for (i=0; i<mask.length; i++){
	            if (mask[i]){
	                l++; 
	            }
	            else {
	                maxl = Math.max(maxl, l); 
	                l=0; 
	            }
	        }
	        maxl = Math.max(maxl, l); 
	        return maxl; 
	    }

}
