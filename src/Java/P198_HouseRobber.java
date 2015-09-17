package Java;

public class P198_HouseRobber {
	public int rob(int[] num) {
        if (num.length==0) return 0; 
        if (num.length==1) return num[0]; 
        if (num.length==2) return Math.max(num[0], num[1]); 
        int a = num[0], t; 
        int b = Math.max(num[0], num[1]); 
        for (int i=2; i<num.length; i++){
            t = a; 
            a = b;
            b = Math.max(t+num[i], b); 
        }
        return b; 
    }
}
