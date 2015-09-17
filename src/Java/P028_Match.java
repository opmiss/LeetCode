package Java;

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
	//KMP algorithm
	public int[] computeTable(String W){
		int[] T = new int[W.length()]; 
		int pos = 2, cnd=0; 
		T[0]=-1; T[1]=0; 
		while (pos <W.length()){
			if (W.charAt(pos-1)==W.charAt(cnd)){
				T[pos]=++cnd; 
				pos++;
			}
			else if (cnd>0){
				cnd=T[cnd]; 
			}
			else T[pos++]=0; 
		}
		return T; 
	}
	public int match(String S, String W){
		int m=0, i=0; 
		int[] T=computeTable(W); 
		while (m+i<S.length()){
			if (W.charAt(i) == S.charAt(i+m)){
				if (i==W.length()-1) return m; 
				i++; 
			}
			else {
				if (T[i]>-1) {
					m=m+i-T[i]; 
					i=T[i]; 
					System.out.println(m); 
				}
				else {
					i=0; 
					m=m+1; 
				}
			}
		}
		return -1; 
	}
}
