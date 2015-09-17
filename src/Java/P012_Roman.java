package Java;
import java.util.*;

public class P012_Roman {
	 public String intToRoman(int num) {
	        StringBuffer roman = new StringBuffer(); 
	        int m = num/1000; 
	        roman.append(convert(m, 'M', 'E', 'E')); 
	        num -= m*1000; 
	        int c = num/100; 
	        roman.append(convert(c, 'C', 'D', 'M'));
	        num -= c*100; 
	        int d = num/10; 
	        roman.append(convert(d, 'X', 'L', 'C')); 
	        num -= d*10; 
	        roman.append(convert(num, 'I', 'V', 'X')); 
	        return roman.toString(); 
	     }
	 public StringBuffer convert(int d, char one, char five, char ten){
	         StringBuffer sb = new StringBuffer(); 
	         if (d==0) return sb; 
	         if (d<=3) for (int i=0; i<d; i++) sb.append(one);
	         else if (d==4) {sb.append(one); sb.append(five); }
	         else if (d>=5 && d<=8) {sb.append(five); for (int i=5; i<d; i++) sb.append(one); }
	         else {sb.append(one); sb.append(ten); }
	         return sb; 
	     }
	 
	 HashMap<Character, Integer> map; 
	    public int romanToInt(String s) {
	        if (s.length() ==0) return 0; 
	        map = new HashMap<Character, Integer>(); 
	        map.put('M', 1000);
	        map.put('D', 500); 
	        map.put('C', 100);
	        map.put('L', 50); 
	        map.put('X', 10);
	        map.put('V', 5);
	        map.put('I', 1);
	        int prev = map.get(s.charAt(0)); 
	        int ret = 0; 
	        for (int i=1; i<s.length(); i++){
	            int num = map.get(s.charAt(i));
	            if (prev < num) ret-=prev; 
	            else ret+=prev;
	            prev = num; 
	        }
	        return (ret+prev); 
	    }

}
