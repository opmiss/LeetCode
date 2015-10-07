package java;
import java.util.*;

public class P215_KthLargest {
	 public int findKthLargest(int[] nums, int k) {
	        Queue<Integer> queue = new PriorityQueue<>(k);
	        for(int i=0;i<nums.length;i++){
	            queue.add(nums[i]);
	            if (queue.size()>k) queue.poll(); 
	        }
	        return queue.poll(); 
	    }

}
