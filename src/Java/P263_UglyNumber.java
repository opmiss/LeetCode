package Java;
import java.util.*;

public class P263_UglyNumber {
	public boolean isUgly(int num) {
		if (num <= 0)
			return false;
		while (num % 2 == 0)
			num >>= 1;
		while (num % 3 == 0)
			num /= 3;
		while (num % 5 == 0)
			num /= 5;
		return (num == 1);
	}
	public int nthUglyNumber(int n) {
        if (n<=6) return n; 
        Queue<Integer> q2 = new LinkedList<Integer>(); 
        Queue<Integer> q3 = new LinkedList<Integer>(); 
        Queue<Integer> q5 = new LinkedList<Integer>();
        q2.add(2); q3.add(3); q5.add(5); 
        int res=0; 
        for (int i=1; i<n; i++){
            res = getMin(q2, q3, q5); 
            System.out.println(res); 
        }
        return res; 
    }
	void add(Queue<Integer> q, int e, int k){
		long a = (long)e*k; 
		if (a>Integer.MAX_VALUE) return; 
		q.add((int)a); 
	}
    int getMin(Queue<Integer> q2, Queue<Integer> q3, Queue<Integer> q5){
        int e2 = q2.isEmpty()?Integer.MAX_VALUE:q2.peek(); 
        int e3 = q3.isEmpty()?Integer.MAX_VALUE:q3.peek();
        int e5 = q5.isEmpty()?Integer.MAX_VALUE:q5.peek(); 
        if (e2<e3){
            if (e2<e5){
                q2.poll(); add(q2, e2, 2); add(q3, e2, 3); add(q5, e2, 5); return e2;   
            }else{
                q5.poll(); add(q5, e5, 5); return e5;  
            }
        }
        else if (e3<e5){
            q3.poll(); add(q3, e3, 3); add(q5, e3, 5); return e3;   
        }
        else {
        	q5.poll(); add(q5, e5, 5); return e5;   
        }
    }
    public static void main(String[] args){
    	P263_UglyNumber p = new P263_UglyNumber(); 
    	p.nthUglyNumber(1600); 
    	//System.out.println(p.nthUglyNumber(7)); 
    }
    
}
