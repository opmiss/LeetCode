package Java;
import java.util.*;

public class P246_StrobogrammaticNumber {
	public boolean isStrobogrammatic(String num) {
	    for (int i=0, j=num.length()-1; i <= j; i++, j--)
	        if (!"00 11 88 696".contains(num.charAt(i) + "" + num.charAt(j)))
	            return false;
	    return true;
	}
	
	public List<String> findStrobogrammatic(int n) {
	    return helper(n, n);
	}

	List<String> helper(int n, int m) {
	    if (n == 0) return new ArrayList<String>(Arrays.asList(""));
	    if (n == 1) return new ArrayList<String>(Arrays.asList("0", "1", "8"));
	    List<String> list = helper(n - 2, m);
	    List<String> res = new ArrayList<String>();
	    for (int i = 0; i < list.size(); i++) {
	        String s = list.get(i);
	        if (n != m) res.add("0" + s + "0");
	        res.add("1" + s + "1");
	        res.add("6" + s + "9");
	        res.add("8" + s + "8");
	        res.add("9" + s + "6");
	    }
	    return res;
	}
	
	public static void main(String[] args){
		P246_StrobogrammaticNumber p = new P246_StrobogrammaticNumber(); 
		System.out.println(p.findStrobogrammatic(3)); 
	}

}
