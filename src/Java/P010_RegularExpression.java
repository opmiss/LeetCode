package Java;
/*
 * Implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * Some examples:
 * isMatch("aa","a") -> false
 * isMatch("aa","aa") -> true
 * isMatch("aaa","aa") -> false
 * isMatch("aa", "a*") -> true
 * isMatch("aa", ".*") -> true
 * isMatch("ab", ".*") -> true
 * isMatch("aab", "c*a*b") -> true
 */

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
