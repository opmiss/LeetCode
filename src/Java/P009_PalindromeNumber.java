package Java;

public class P009_PalindromeNumber {
	 public static boolean isPalindrome(int x) {
	    	if (x<0) return false; 
	    	if (x<10) return true; 
	    	if (x%10==0) return false; 
	    	
	    	int rev = 0; 
	    	
	    	while (x>0 && x>rev){
	    		rev += x%10; 
	    		x = x/10; 
	    		rev = rev*10; 
	    	}
	    	if (x!=rev) rev = rev/10; 
	    	if (x == rev || x == (rev/10)) return true; 
	    	else return false; 
	    }

}
