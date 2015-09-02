package problems.math;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * For example,
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 */

public class Fraction {
    public String fractionToDecimal(int numerator, int denominator) {
    	StringBuffer ret = new StringBuffer(); 
    	Map seen = new HashMap<Double, Integer>(); 
    	double numer = numerator; 
    	double denom = denominator; 
    	double qo = numer/denom; 
    	if (qo<0) ret.append('-'); 
    	ret.append(String.format("%d", (long)Math.abs(qo))); 
    	numer = Math.abs(numer);
    	denom = Math.abs(denom); 
    	numer = Math.abs(numerator%denominator); 
    	if (numer>0) ret.append('.'); 
    	while (ret.length()<10000){
    		if ((int)numer==0) return ret.toString(); 
    		if (seen.containsKey(numer)){
    			ret.insert((int)seen.get(numer), '('); 
    			ret.append(')');
    			return ret.toString(); 
    		}
    		seen.put(numer, ret.length()); 
    		numer = numer*10; 
    		while(numer<denom){
    			ret.append('0'); 
    			seen.put(numer, ret.length()); 
    			numer = numer*10; 
    		}
    		int q = (int)(numer/denom); 
    		ret.append(Character.forDigit(q, 10));
    		numer = numer-denom*q; 
    	}
    	return ret.toString(); 
    }
    
    public static void main(String[] args){
    	Fraction f = new Fraction(); 
    	//System.out.println(-5%-3); 
    	System.out.println(f.fractionToDecimal(1, -2147483648)); 
    	//System.out.println(f.fractionToDecimal(-2147483648, 1));
    }
}
