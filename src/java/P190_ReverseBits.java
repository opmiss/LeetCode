package java;

public class P190_ReverseBits {
	// you need treat n as an unsigned value
    public static int reverseBits(int n) {
        n = ((n&0x0000ffff)<<16)|((n&0xffff0000)>>>16); 
        n = ((n&0x00ff00ff)<<8)|((n&0xff00ff00)>>>8); 
        n = ((n&0x0f0f0f0f)<<4)|((n&0xf0f0f0f0)>>>4);
        n = ((n&0x33333333)<<2)|((n&0xcccccccc)>>>2); 
        n = ((n&0x55555555)<<1)|((n&0xaaaaaaaa)>>>1);
        return n; 
    }
    public static void main(String[] args){
    	int n = 0b11101; 
    	String before = Integer.toBinaryString(n); 
    	String after = Integer.toBinaryString(reverseBits(n)); 
    	System.out.println(before+"-->"+after); 
    }
}
