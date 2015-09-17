package Java;

public class P026_RemoveDuplicates {
	public int removeDuplicates(int[] A) {
        if (A.length <= 1) return A.length; 
        int base = 0; 
        int iter = 1; 
        while (iter<A.length){
            if (A[iter] != A[base]) {
                base++; 
                A[base] = A[iter]; 
            }
            iter++; 
        }
        return base+1; 
    }
}
