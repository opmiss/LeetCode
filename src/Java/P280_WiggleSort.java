package Java;

public class P280_WiggleSort {
	/*Given a unsorted array, and re-arrange it to wiggle style in one pass.
	i.e. [1] A0 >= A1 <= A2 >= A3 .... .... An.
	     [2] A0 <= A1 >= A2 <= A3 .... .... An.*/
	public int[] wiggleSort(int[] nums) {
		for (int i=1; i<nums.length; i++){
			if ((i%2==0&&nums[i]>nums[i-1])||(i%2==1&&nums[i]<nums[i-1])){
				int temp = nums[i]; 
				nums[i] = nums[i-1]; 
				nums[i-1] = temp; 
			}
		}
		return nums; 
	}
	
	public static void main(String[] args){
		P280_WiggleSort p = new P280_WiggleSort(); 
		int[] nums = p.wiggleSort(new int[]{1, 6, 7, 2, 8, 9, 3});
		for (int i=0; i<nums.length; i++) System.out.println(nums[i]); 
	}

}
