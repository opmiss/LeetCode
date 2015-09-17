package Java;
import java.util.*;
/* 
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. 
 * Find and return the shortest palindrome you can find by performing this transformation.
 * For example:
 * Given "aacecaaa", return "aaacecaaa".
 * Given "abcd", return "dcbabcd".
*/

public class P214_ShortestPalindrome {
	
	public String shortestPalindrome(String s){
		String r = new StringBuilder(s).reverse().toString();
		//max match between prefix of s and suffix of r 
		int[] table = computeTable(s+'|'+r); 
		return r.substring(0, r.length()-table[table.length-1])+s; 
	}
	
	public int[] computeTable(String W){
		int[] T = new int[W.length()]; 
		int pos = 1, leng=0;  
		while (pos <W.length()){
			if (W.charAt(pos)==W.charAt(leng)){
				T[pos++]=++leng; 
			}
			else if (leng>0){
				leng=T[leng-1]; 
			}
			else T[pos++]=0; 
		}
		return T; 
	}
	public static void main(String[] args){
		P214_ShortestPalindrome p = new P214_ShortestPalindrome(); 
		System.out.println(p.shortestPalindrome("aacecaaa")); 
	}
}
