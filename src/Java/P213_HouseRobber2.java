package Java;

public class P213_HouseRobber2 {
	public int rob(int[] nums) {
        if (nums.length==0) return 0; 
        if (nums.length==1) return nums[0]; 
        return Math.max(rob(nums, 0, nums.length-2), rob(nums, 1, nums.length-1)); 
    }
    
    public int rob(int[] nums, int start, int end){
        int a = nums[start]; 
        if (start==end) return a;
        int b = Math.max(a, nums[start+1]);
        if (start+1==end) return b; 
        for (int i=start+2; i<=end; i++){
            int t = a+nums[i]; 
            a = b; 
            b = Math.max(b, t); 
        }
        return b; 
    }
}
