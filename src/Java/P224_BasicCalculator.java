package Java;
import java.util.*; 

public class P224_BasicCalculator {
	public int calculate(String s) {
        Stack<String> stack = new Stack<String>(); 
        ArrayList<String> output = new ArrayList<String>(); 
        //first convert expression to reverse polish notation
        String number = ""; 
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)==' ') continue; 
            if (s.charAt(i)>='0'&&s.charAt(i)<='9'){
                number+=s.charAt(i); continue; 
            } 
            if (s.charAt(i)=='+'||s.charAt(i)=='-'){
                if (number.length()>0) output.add(number); 
                number=""; 
                if (stack.isEmpty()) stack.push(""+s.charAt(i)); 
                else {
                    while (stack.peek().equals("+")||stack.peek().equals("-")){
                        output.add(stack.pop());
                        if (stack.isEmpty()) break; 
                    }
                    stack.push(""+s.charAt(i));
                }
                continue; 
            }
            if (s.charAt(i)=='('){
                stack.push(""+s.charAt(i)); 
                continue; 
            }
            if (s.charAt(i)==')'){
                if (number.length()>0) output.add(number);
                number=""; 
                while (!stack.peek().equals("(")) {
                    output.add(stack.pop()); 
                }
                stack.pop(); 
                continue; 
            }
        }
        if (number.length()>0) output.add(number); 
        while (!stack.isEmpty()) output.add(stack.pop());
        System.out.println(output); 
        int left, right; 
        Stack<Integer> res = new Stack<Integer>(); 
        for (int i=0; i<output.size(); i++){
            if (output.get(i).equals("+")){
                right = res.pop(); 
                left = res.pop();
                res.push(right+left);
                continue; 
            }
            if (output.get(i).equals("-")){
                right = res.pop(); 
                left = res.pop();
                res.push(left-right);
                continue; 
            }
            res.push(Integer.parseInt(output.get(i))); 
        }
        return res.pop(); 
     }
	
	public static void main(String[] args){
		P224_BasicCalculator p = new P224_BasicCalculator(); 
		System.out.println(p.calculate("(4+9)")); 
		
	}

}
