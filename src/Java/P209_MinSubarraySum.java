package Java;

public class P209_MinSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
        if (nums.length<1) return 0; 
        int i = 0; 
        int j = 1; 
        int sum = nums[0]; 
        int minLength = Integer.MAX_VALUE; 
        while (i<nums.length){
            if (sum>=s) {
                minLength=Math.min(j-i, minLength); 
                sum-=nums[i]; 
                i++; 
            }
            else if (j<nums.length){
                sum+=nums[j]; 
                j++; 
            }
            else break; 
        }
        if (sum>=s) minLength=Math.min(j-i, minLength); 
        return (minLength>nums.length)?0:minLength; 
    }
}
