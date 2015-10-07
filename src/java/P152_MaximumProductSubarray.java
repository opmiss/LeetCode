package java;

public class P152_MaximumProductSubarray {
	public int maxProduct(int[] A) {
        if (A.length==1) return A[0];
        int maxhere = 0; 
        int minhere = 0; 
        int maxprod = A[0];
        for (int i=0; i<A.length; i++){
            if (A[i]>0){
                maxhere = (maxhere>0)?maxhere*A[i]:A[i];
                minhere = (minhere<0)?minhere*A[i]:0; 
            }
            else if (A[i]<0) {
                int t = maxhere; 
                maxhere = (minhere<0)?minhere*A[i]:0; 
                minhere = (t>0)?t*A[i]:A[i]; 
            }
            else {
                maxhere=minhere=0; 
            }
            maxprod = (maxprod<maxhere)?maxhere:maxprod;
        }
        return maxprod;
    }
}
