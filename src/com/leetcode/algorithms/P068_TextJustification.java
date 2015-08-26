package com.leetcode.algorithms;
import java.util.*;

/*
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. 
 * Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 * Extra spaces between words should be distributed as evenly as possible. 
 * If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.
 */

public class P068_TextJustification {
	public ArrayList<String> fullJustify(String[] words, int L) {
		ArrayList<String> res = new ArrayList<String>(); 
		ArrayList<String> line = new ArrayList<String>(); 
		int fill=0; 
		for (String w:words){
			if (fill+w.length()<=L){
				line.add(w); 
				fill+=w.length()+1; 
			}
			else {
				res.add(convert(line, fill, L)); 
				line.clear(); 
				line.add(w); 
				fill = w.length()+1; 
			}
		}
		res.add(convertLast(line, fill, L)); 
		return res; 
	}
	String convert(ArrayList<String> line, int fill, int L){
		StringBuffer sb = new StringBuffer(); 
		int slength = L-fill+line.size(); 
		if (line.size()==1){
			sb.append(line.get(0));
			for (int i=0; i<slength; i++) sb.append(' ');
			return sb.toString(); 
		}
		int a = slength/(line.size()-1); //min num of spaces between words  
		int b = slength-a*(line.size()-1); //num of blanks should be a extra space; 
		sb.append(line.get(0));
		for (int i=0; i<line.size()-1; i++){
			if (i<b){
				for (int k=0; k<a+1; k++) sb.append(' '); 
			}
			else for (int k=0; k<a; k++) sb.append(' '); 
			sb.append(line.get(i+1)); 
		}
		return sb.toString(); 
	}
	String convertLast(ArrayList<String> line, int fill, int L){
		StringBuffer sb = new StringBuffer(); 
		for (String w:line){
			sb.append(w);
			sb.append(' '); 
		}
		if (sb.length()>L){
			sb.deleteCharAt(L); 
		}else {
			int num = L-sb.length(); 
			for (int i=0; i<num; i++) sb.append(' '); 
		}
		return sb.toString(); 
	}
	
	public static void main(String[] args){
		P068_TextJustification p = new P068_TextJustification(); 
		System.out.println(p.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16)); 
		System.out.println(p.fullJustify(new String[]{"Listen","to","many,","speak","to","a","few."}, 6)); 
	}

}
