package java;

public class P287_FindDuplicate {
	  public int findDuplicate(int[] nums) {
	        int start = nums.length-1; 
	        while (start>=0){
	            if (nums[start]!=start+1) break;
	            start--; 
	        }
	        int slow = nums[start]-1, fast = nums[slow]-1;
	        while (slow!=fast){
	            slow = nums[slow]-1; 
	            fast = nums[fast]-1; 
	            fast = nums[fast]-1;
	        }
	        slow = start; 
	        while (slow!=fast){
	            slow = nums[slow]-1; 
	            fast = nums[fast]-1; 
	        }
	        return slow+1; 
	    }
}
