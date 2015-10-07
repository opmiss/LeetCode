package java;

public class P189_RotateArray {
	public void rotate(int[] nums, int k) {
        k = k%nums.length; 
        if (k==0) return; 
        int[] r = new int[nums.length]; 
        int s = nums.length-k; 
        for (int i=0; i<nums.length; i++){
            r[i] = nums[s]; 
            s = (s+1)%nums.length; 
        }
        for (int i=0; i<nums.length; i++) nums[i]=r[i]; 
    }
}
