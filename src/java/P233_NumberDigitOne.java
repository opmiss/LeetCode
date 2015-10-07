package java;

public class P233_NumberDigitOne {
	public int countDigitOne(int n) {
        int count =0; 
        for (long d=1; d<=n; d*=10){
            int x = n/(int)d;
            int y = x/10; 
            int s = x-y*10; 
            if (s==1) count+=n-x*d+1; 
            else if (s>1) y++; 
            count+=y*d; 
        }
        return count; 
    }
	public static void main(String[] args){
		P233_NumberDigitOne p = new P233_NumberDigitOne(); 
		System.out.println(p.countDigitOne(1410065408)); 
		//System.out.println(p.countDigitOne(1599990)); 
		//System.out.println(p.countDigitOne(1600000)); 
	}
}
