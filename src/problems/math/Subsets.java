package problems.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/* 
 * Given a set of distinct integers, S, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example, if S = [1,2,3], a solution is:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
*/

public class Subsets {
    
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
    	Arrays.sort(num);
     	ArrayList<Integer> list = new ArrayList<Integer>(); 
    	for (int n:num) list.add(n); 
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); 
    	subset(list, 0, new ArrayList<Integer>(), result);  
    	return result; 
    }
    void subset(ArrayList<Integer> S, int start, ArrayList<Integer> output, ArrayList<ArrayList<Integer>> result) {
        result.add(new ArrayList(output));
        for (int i = start; i < S.size(); i++) {
        	if (i>0&&S.get(i)==S.get(i-1)) continue; 
            output.add(S.get(i));
            subset(S, i + 1, output, result);
            output.remove(output.size()-1); 
            // disable following line for subset I
           // while (i + 1 < S.size() && S.get(i+1) == S.get(i)) i++;
        }
    }
    public void test(){
    	int[] num = new int[]{1, 2, 3}; 
    	System.out.println(subsetsWithDup(num)); 
    }
    public static void main(String[] args){
    	Subsets s = new Subsets(); 
    	s.test(); 
    }
}
