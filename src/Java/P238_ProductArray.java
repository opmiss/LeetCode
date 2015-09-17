package Java;

public class P238_ProductArray {
	public int[] productExceptSelf(int[] nums) {
        int prod = 1; 
        boolean allzero=true;
        boolean onezero=false;
        boolean twozero=false; 
        for (int num:nums){
            if (num!=0) {
                allzero=false; 
                prod *=num;
            }
            else {
                if (!onezero && !twozero) {
                    onezero = true;
                }
                else if (!twozero){
                    twozero = true; 
                    onezero = false; 
                }
            }
        }
        for (int i=0; i<nums.length; i++){
            if (allzero) {
                nums[i] = 0;
            }
            else if (nums[i]==0){
                if (twozero) nums[i]=0; 
                else nums[i] = prod; 
            }
            else {
                if (onezero||twozero) {
                    nums[i] = 0; 
                }
                else nums[i] = prod/nums[i]; 
            }
        }
        return nums; 
    }
}
