package java;
import java.util.*;

public class P001_TwoSum {
	 HashMap<Integer, Integer> map; 
	    public int[] twoSum(int[] numbers, int target) {
	        map = new HashMap<Integer, Integer>(); 
	        for (int i=0; i<numbers.length; i++){
	            map.put(numbers[i], (i+1)); 
	        }
	        for (int i=0; i<numbers.length; i++){
	            int find = target - numbers[i]; 
	            if (map.containsKey(find) && ((i+1)<map.get(find)) ){
	                int[] ret = new int[2]; 
	                ret[0]=(i+1); 
	                ret[1]=map.get(find); 
	                return ret; 
	            }
	        }
	        return null; 
	    }

}
