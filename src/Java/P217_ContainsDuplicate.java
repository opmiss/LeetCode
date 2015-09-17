package Java;
import java.util.*;

public class P217_ContainsDuplicate {
	 public boolean containsDuplicate(int[] nums) {
	        Set<Integer> set = new HashSet<Integer>(); 
	        for (int n:nums) if (!set.add(n)) return true; 
	        return false; 
	    }

}
