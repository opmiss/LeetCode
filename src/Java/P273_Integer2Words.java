package Java;
import java.util.*;

public class P273_Integer2Words {
	String[] scale = new String[]{"Thousand", "Million", "Billion"}; 
    String[] digit = new String[]{"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = new String[]{"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"}; 
    public String numberToWords(int num) {
        if (num==0) return "Zero"; 
        StringBuffer sb = new StringBuffer(); 
        if (num<1000){
            int h = num/100; 
            if (h>0) {
                sb.append(digit[h-1]);
                sb.append(' ');
                sb.append("Hundred"); 
            }
            num -= h*100;
            if (num==0) return sb.toString(); 
            if (num<20){
                if (sb.length()>0) sb.append(' '); 
                sb.append(digit[num-1]);
                return sb.toString(); 
            }
            int t = num/10; 
            if (sb.length()>0) sb.append(' '); 
            sb.append(tens[t-2]);
            num -=t*10; 
            if (num>0) {
                sb.append(' '); sb.append(digit[num-1]);
            }
            return sb.toString(); 
        }
        List<String> list = new ArrayList<String>(); 
        while (num>0){
            list.add(numberToWords(num%1000));
            num/=1000; 
        }
        for (int i = list.size()-1; i>=0; i--){
            if (!list.get(i).equals("Zero")) {
                if (sb.length()>0) sb.append(' '); 
                sb.append(list.get(i)); 
                if (i>0){
                    sb.append(' ');
                    sb.append(scale[i-1]);
                }
            }
        }
        return sb.toString(); 
    }
}
