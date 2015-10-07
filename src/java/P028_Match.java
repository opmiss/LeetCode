package java;

public class P028_Match {
	public int strStr(String haystack, String needle) {
        for (int i=0; i<haystack.length()-needle.length()+1; i++){
            int j=0; 
            while (j<needle.length()){
                if (haystack.charAt(i+j)==needle.charAt(j)) j++; 
                else break; 
            }
            if (j==needle.length()) return i; 
        }
        return -1; 
    }
}
