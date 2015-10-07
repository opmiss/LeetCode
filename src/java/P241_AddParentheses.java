package java;
import java.util.*;

public class P241_AddParentheses {
	 public List<Integer> diffWaysToCompute(String input) {
	        List<Integer> res = new ArrayList<Integer>(); 
	        if (input.isEmpty()) return res; 
	        int num = (int)input.charAt(0)-48;
	        int i =1; 
	        while (i<input.length() && input.charAt(i)>='0'){
	            num = num*10 + (int)input.charAt(i)-48; 
	            i++; 
	        }
	        if (i==input.length()) {
	            res.add(num); 
	            return res; 
	        }
	        while (i<input.length()){
	            if (input.charAt(i)<'0'){
	                List<Integer> left = diffWaysToCompute(input.substring(0, i)); 
	                List<Integer> right = diffWaysToCompute(input.substring(i+1));
	                for (Integer l:left){
	                    for (Integer r:right){
	                        res.add(eval(l, r, input.charAt(i))); 
	                    }
	                }
	            }
	            i++; 
	        }
	        return res; 
	    }
	    
	    public Integer eval(Integer l, Integer r, char op){
	        switch(op){
	            case '+':
	                return l+r; 
	            case '-':
	                return l-r; 
	            case '*': 
	                return l*r; 
	        }
	        return l; 
	    }

}
