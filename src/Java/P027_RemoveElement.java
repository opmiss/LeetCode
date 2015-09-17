package Java;

public class P027_RemoveElement {
	 public int removeElement(int[] A, int elem) {
	        int base = 0; 
	        int i=0; 
	        while (i<A.length){
	            if (A[i]!=elem) {A[base] = A[i]; base++;}
	            i++; 
	        }
	        return base; 
	    }

}
