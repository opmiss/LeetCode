package java;
import java.util.*;

public class P015_3Sum {
	public List<List<Integer>> threeSum(int[] num) {
        //similar solution as 3sum closest
        List<List<Integer>> ret = new ArrayList<List<Integer>>(); 
        if (num.length<3) return ret; 
        Set<List<Integer>> sols = new HashSet<List<Integer>>(); 
        Arrays.sort(num);
        for (int i=0; i<num.length-2; i++){
            int n1 = num[i]; 
            int tar = 0-num[i]; 
            int j=i+1; 
            int k=num.length-1; 
            while (k>j){
                int sum = num[k]+num[j]; 
                if (sum == tar) {
                    List<Integer> sol = new ArrayList<Integer>(); 
                    sol.add(n1); sol.add(num[j]); sol.add(num[k]);  
                    sols.add(sol); k--;
                }
                else if (sum>tar) k--; 
                else j++; 
            }
        }
        ret.addAll(sols);
        return ret; 
    }

}
