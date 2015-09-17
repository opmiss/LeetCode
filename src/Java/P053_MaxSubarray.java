package Java;

public class P053_MaxSubarray {
	/*
	 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
	 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
	 * the contiguous subarray [4,-1,2,1] has the largest sum = 6
	 */
	public int maxSum(int[] A) {
		if (A.length == 1)
			return A[0]; 
		int sumhere=A[0]; 
		int maxsum=A[0]; 
		for (int i=1; i<A.length; i++) {
			sumhere = (sumhere<0)?A[i]:(sumhere+A[i]); 
			maxsum = (maxsum<sumhere)?sumhere:maxsum; 
		}
		return maxsum; 
	}

}
