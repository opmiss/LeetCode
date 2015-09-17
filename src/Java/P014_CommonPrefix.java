package Java;

public class P014_CommonPrefix {
	 public String longestCommonPrefix(String[] strs) {
	        if (strs.length==0) return ""; 
	        if (strs.length==1) return strs[0];  
	        StringBuffer sb = new StringBuffer(); 
	        for (int i=0; i<strs[0].length(); i++){
	            char c = strs[0].charAt(i); 
	            boolean add = true; 
	            for (int k=1; k<strs.length; k++){
	                if (add && i<strs[k].length()) { if (strs[k].charAt(i)!=c) add=false; }
	                else { add=false; break;} 
	            }
	            if (add) sb.append(c); 
	            else break; 
	        }
	        return sb.toString(); 
	    }

}
