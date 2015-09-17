package Java;

public class P153_MinimuminRotated {
	public int findMin(int[] num) {
        return findMin(num, 0, num.length-1); 
    }
    public int findMin(int[] num, int s, int e){
        if (e-s < 1) return num[s]; 
        if (e-s == 1) return (num[s]<num[e])?num[s]:num[e]; 
        else if (num[s]<num[e]){
            return num[s]; 
        }
        else {
            int m = (s+e)/2; 
            int m1 = findMin(num, s, m);
            int m2 = findMin(num, m, e);
            return (m1<m2)?m1:m2; 
        }
    }

}
