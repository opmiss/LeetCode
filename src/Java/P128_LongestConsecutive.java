package Java;
import java.util.*;

public class P128_LongestConsecutive {
	/* Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
	 * For example,
	 * Given [100, 4, 200, 1, 3, 2],
	 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
	 * Your algorithm should run in O(n) complexity.
	 */
	public int longestConsecutive(int[] nums) {
		int maxLeng = 0, newLeng; 
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int num:nums){
			if (map.get(num)!=null) continue; 
			Integer left = map.get(num-1); 
			Integer right = map.get(num+1);
			if (left==null&&right==null){
				newLeng = 1; 
			}
			else if (left==null){
				newLeng=right+1; 
				map.put(num+right, newLeng); 
			}
			else if (right==null){
				newLeng=left+1; 
				map.put(num-left, newLeng); 
			}
			else {
				newLeng = left+right+1; 
				map.put(num+right, newLeng); 
				map.put(num-left, newLeng);
			}
			map.put(num, newLeng); 
			maxLeng = Math.max(maxLeng, newLeng); 
		}
		return maxLeng; 
    }

}
