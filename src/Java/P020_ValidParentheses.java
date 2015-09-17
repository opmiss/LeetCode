package Java;
import java.util.*;

public class P020_ValidParentheses {
	public boolean isValid(String s) {
        int l = s.length(); 
        if (l==0) return true; 
        if (l%2!=0) return false;
        Stack<Character> stack = new Stack<Character>(); 
        for (int i=0; i<l; i++){
            Character c = s.charAt(i); 
            if (c.equals('(') || c.equals('[') || c.equals('{')) stack.push(c); 
            else {
                if (stack.isEmpty()) return false; 
                Character o = stack.pop(); 
                if (o.equals('(') && (!c.equals(')'))) return false;  
                else if (o.equals('[') && (!c.equals(']'))) return false; 
                else if (o.equals('{') && (!c.equals('}'))) return false; 
            }
        }
        if (stack.isEmpty()) return true; 
        return false; 
    }
}
