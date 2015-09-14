package java;

import java.util.*;

public class P139_WordBreak {
	/*
	 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
	 * Return all such possible sentences. 
	 * For example, given
	 * s = "catsanddog",
	 * dict = ["cat", "cats", "and", "sand", "dog"].
	 * A solution is ["cats and dog", "cat sand dog"].
	 */
	public List<String> wordBreak(String s, Set<String> dict) {
		 int[] r = getLengthRange(dict);
		 return helper(s, dict, r[0], r[1]); 
	 }
	 
	 public List<String> helper(String s, Set<String> dict, int minL, int maxL){
		 List<String> ret = new ArrayList<String>();
		 if (s==null || s.length() < minL) return ret; 
		 int sl= s.length(); 
		 maxL = (maxL<sl)?maxL:sl; 
		 
		 boolean stop = true; 
		 for (int i=minL; i<=maxL; i++) if (dict.contains(s.substring(s.length()-i))) {stop=false; break;} 
		 if (stop) return ret; 
		 
		 String head; 
		 for (int i=minL; i<=maxL; i++){
			 head = s.substring(0, i); 
			 if (dict.contains(head)){
			     if (i==sl) {
			    	 ret.add(head); 
			    	 return ret; 
			     }
			     List<String> rest = helper(s.substring(i), dict, minL, maxL); 
			     for (String p:rest){ 
			    	 ret.add(head+" "+p); 
			     }
			 }
		 }
		 return ret; 
	 }
	
	 int[] getLengthRange(Set<String> dict){
		 int[] range=new int[2]; 
		 range[0] = Integer.MAX_VALUE; 
		 for (String s:dict){
		     int sl = s.length();
			 range[0] = (range[0]<sl)? range[0]:sl; 
			 range[1] = (range[1]>sl)? range[1]:sl; 
		 }
		 return range; 
	 }
	 
	 /*
	  * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
	  * For example, given
	  * s = "leetcode",
	  * dict = ["leet", "code"].
	  * Return true because "leetcode" can be segmented as "leet code".
	  */
	  public boolean canBreak(String s, Set<String> dict) {
		  boolean[][] canBreak = new boolean[s.length()][s.length()]; 
		  for (int k=0; k<s.length(); k++){
			  for (int i=0; i<s.length()-k; i++){
				  canBreak[i][i+k] = dict.contains(s.substring(i, i+k+1)); 
				  int j=0; 
				  while (!canBreak[i][i+k]&&j<k){
					  canBreak[i][i+k] = canBreak[i][i+j] && canBreak[i+j+1][i+k];
					  j++; 
				  }
			  }
		  }
		  return canBreak[0][s.length()-1]; 
	  }
	  
	  public static void main(String[] args){
		  Set<String> dict = new HashSet<String>(); 
		  dict.add("hello"); 
		  dict.add("world"); 
		  String s = "helloworld"; 
		  P139_WordBreak wb=new P139_WordBreak(); 
		  System.out.println(wb.canBreak(s, dict)); 
		  
		  dict.add("cat"); 
		  dict.add("cats"); 
		  dict.add("and"); 
		  dict.add("sand"); 
		  dict.add("dog"); 
		  
		  s = "catsanddog"; 
		  
		  List<String> list=wb.wordBreak(s, dict);
		  for (String l:list) System.out.println(l); 
	  }

}
