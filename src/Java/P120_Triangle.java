package Java;

import java.util.ArrayList;

/* Given a triangle, find the minimum path sum from top to bottom. 
 * Each step you may move to adjacent numbers on the row below.
For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
*/

public class P120_Triangle {
	  public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
	        if (triangle == null) return 0; int depth = triangle.size(); 
	        if (depth == 0) return 0;
	        if (depth == 1) return triangle.get(0).get(0); 
	        ArrayList<Integer> sum = triangle.get(depth-1); 
	        for (int d = depth-2; d >=0; d--){
	            sum = minsum(triangle.get(d), sum); 
	        }
	        return sum.get(0); 
	    }
	    
	    //compute the min sum at each position of the triangle, from bottom to top
	    public ArrayList<Integer> minsum(ArrayList<Integer> row, ArrayList<Integer> sum){
	        ArrayList<Integer> ret = new ArrayList<Integer>(); 
	        for (int i=0; i<row.size(); i++){
	            ret.add((row.get(i)+Math.min(sum.get(i), sum.get(i+1))));
	        }
	        return ret; 
	    }

}
