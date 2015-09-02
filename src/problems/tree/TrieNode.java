package problems.tree;
import java.util.*;

public class TrieNode {
	public boolean endhere = false; 
    public TrieNode[] child = null; 
    public TrieNode() {
    }
    public void insert(String w){
    	if (w.length()<1) {endhere = true; return;}
    	int id = (int)w.charAt(0) -'a'; 
    	if (child==null) child = new TrieNode[26]; 
    	if (child[id]==null) child[id] = new TrieNode(); 
    	child[id].insert(w.substring(1));
    }
    public boolean search(String w){
    	if (w.length()<1) return endhere;
    	int id = (int)w.charAt(0) -'a'; 
    	if (child==null || child[id]==null) return false;  
    	return child[id].search(w.substring(1));
    }
    
    public boolean searchReg(String w){
    	if (w.length()<1) return endhere;
    	if (child==null) return false; 
    	if (w.charAt(0)=='.'){
    		for (int i=0; i<26; i++){
    			if (child[i]==null) continue; 
    			if (child[i].searchReg(w.substring(1))) return true; 
    		}
    		return false; 
    	}
    	int id = (int)w.charAt(0) -'a'; 
    	if (child[id]==null) return false;  
    	return child[id].searchReg(w.substring(1));
    	
    }
    
    public boolean startsWith(String w){
      	if (w.length()<1) return true;
    	int id = (int)w.charAt(0) -'a'; 
    	if (child==null || child[id]==null) return false;  
    	return child[id].startsWith(w.substring(1));
    }
    
    public static void main(String[] args){
    	TrieNode root = new TrieNode(); 
    	root.insert("abc");
    	root.insert("a");
    	System.out.println(root.search("ab")); 
    	System.out.println(root.startsWith("ab")); 
    	System.out.println(root.searchReg("..")); 
    }
}
