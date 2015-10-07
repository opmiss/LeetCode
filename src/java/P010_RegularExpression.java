package java;

public class P010_RegularExpression {
	 public boolean isMatch(String s, String p) {
	        int sl = s.length(), pl = p.length(); 
			int si =0, pi=0; 
			while (si<sl){
				if (pi==pl-1 || (pi+1<pl && p.charAt(pi+1)!='*')){
					if (p.charAt(pi)=='.' || s.charAt(si)==p.charAt(pi)) {pi++; si++;}
					else return false; 
				}
				else if (pi+1<pl){
					if (isMatch(s.substring(si), p.substring(pi+2))) return true; 
					else if (p.charAt(pi)=='.' || s.charAt(si)==p.charAt(pi)) si++; 
					else return false; 
				}
				else return false; 
			}
			while (pi+1<pl && p.charAt(pi+1)=='*') pi+=2; 
			return (si==sl&&pi==pl); 
	    }

}
