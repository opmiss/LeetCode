package Java;

public class P136_SingleNumber {
	
	public int singleNumber(int[] A) {
        int s = A[0]; 
		for (int i=1; i<A.length; i++)
			s=s^A[i]; 
        return s; 
    }
	
	public int singleNumberII(int[] A) {
        int m1 = A[0]; 
        int m2 = 0; 
        int _m2; 
        for (int i=1; i<A.length; i++){
            _m2 = m2; 
            m2 = (m1&A[i])|(_m2&(~A[i]));
            m1 = (m1&(~A[i]))|((~m1)&(~_m2)&A[i]); 
        }
        return m1; 
    }
	
	public int[] singleNumberIII(int[] A) {
		int or = 0; 
        for(int i=0; i<A.length; i++){
        	or = or^A[i]; 
        }
        or = or&(-or);
        int[] res = new int[2]; 
        for (int i=0; i<A.length; i++){
        	if ((A[i]&or)==0){
        		res[0]^=A[i]; 
        	}else {
        		res[1]^=A[i]; 
        	}
        }
		return res; 
    }
	
	/*
	 * Given an array of integers, every element appears N times except for one. Find that single one.
	 */
	
	public int singleNumberN(int[] A, int N){
		int[] m = new int[N]; int _m; 
		m[0] = ~A[0]; m[1] = A[0]; 
		for (int i=1; i<A.length; i++){
			_m = m[N-1]; 
			for (int k=N-1; k>0; k--){
				m[k] = (m[k-1]&A[i])|(m[k]&(~A[i]));
			}
			m[0] = (_m&A[i])|(m[0]&(~A[i])); 
		}
		return m[1]; 
	}
	
	public static void main(String[] args){
		P136_SingleNumber p = new P136_SingleNumber(); 
		int[] singles = p.singleNumberIII(new int[]{1, 2, 3, 1, 2, 3, 8, 6}); 
		System.out.println(singles[0]+", "+singles[1]); 
	}
}
