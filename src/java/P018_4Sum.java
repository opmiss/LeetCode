package java;
import java.util.*;
import java.util.Map.Entry;

/* *
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
 * Find all unique quadruplets in the array which gives the sum of target.
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a <= b <= c <= d)
 * The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * A solution set is:
 * (-1,  0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2,  0, 0, 2) 
 * */

public class P018_4Sum {
	HashMap<Integer, ArrayList<Integer>> map; 
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>(); 
        if (num.length<4) return ret; 
        Arrays.sort(num); 
        map = new HashMap<Integer, ArrayList<Integer>>(); 
        for (int i=num.length-1; i>0; i--){
            if (i < num.length-1 && num[i] == num[i+1]) continue; 
            for (int j=i-1; j>=0; j--){
                if (j < i-1 && num[j] == num[j+1]) continue; 
                ArrayList<Integer> list = map.get((num[i]+num[j]));
                if (list==null) list = new ArrayList<Integer>(); 
                list.add(j); list.add(i);  
                map.put((num[i]+num[j]), list); 
            }
        }
        for (int i=0; i<num.length-1; i++){
            if (i>0 && num[i] == num[i-1]) continue; 
            for (int j=i+1; j<num.length; j++){
                if (j>(i+1) && num[j]==num[j-1]) continue; 
                ArrayList<Integer> list = map.get(target-(num[i]+num[j])); 
                if (list==null) continue; 
                for (int k=0; k<list.size(); k+=2){
                    if (list.get(k) >j){
                        ArrayList<Integer> sol = new ArrayList<Integer>(); 
                        sol.add(num[i]); sol.add(num[j]);
                        sol.add(num[list.get(k)]);  sol.add(num[list.get(k+1)]); 
                        ret.add(sol); 
                    }
                }
            }
        }
        return ret; 
    }
    /* Given an array S of n integers, find consecutive integers in S such that the sum is equal to a given number, target. 
	  * Return the sub-array. You may assume that each input would have exactly one solution. The algorithm should run in O(n).
	  */
	public List<List<Integer>> arraySum(int[] num, int target){
		List<List<Integer>> ret = new ArrayList<List<Integer>>(); 
		int[] leftsum = new int[num.length];
		leftsum[0] = num[0]; 
		for (int i=1; i<num.length; i++){
			leftsum[i] = num[i]+leftsum[i-1];
			if (leftsum[i]==target) {
				ArrayList<Integer> sol = new ArrayList<Integer>(); 
				sol.add(0); sol.add(i); 
				ret.add(sol); 
			}
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 
		for (int i=0; i<num.length; i++){
			map.put(leftsum[i], i); 
		}
		for (Entry<Integer, Integer> e:map.entrySet()){
			Integer t = map.get(e.getKey()-target); 
			if (t!=null && t<e.getValue()){
				ArrayList<Integer> sol = new ArrayList<Integer>(); 
				sol.add(t+1); sol.add(e.getValue()); 
				ret.add(sol); 
			}
		}
		return ret; 
	}
}
