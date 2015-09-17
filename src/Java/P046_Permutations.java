package Java;
import java.util.*;

public class P046_Permutations {
	 public List<List<Integer>> permuteUnique(int[] nums) {
		 Arrays.sort(nums); 
		 List<Integer> list = new ArrayList<Integer>(); 
		 for (int num:nums) {
			 list.add(num);
		 }
		 return genPermute(list);  
	 }
	 
	 public List<List<Integer>> genPermute(List<Integer> nums){
		 List<List<Integer>> res = new ArrayList<List<Integer>>(); 
		 if (nums.size()==1){
			 res.add(new ArrayList<Integer>(nums)); 
			 return res; 
		 }
		 int i=0; 
		 do{
			 int e = nums.remove(i); 
			 List<List<Integer>> subres = genPermute(nums);
			 for (List<Integer> list:subres){
				 list.add(e); 
				 res.add(list);
			 }
			 nums.add(i, e);
			 i++; 
			 while (i<nums.size()&&nums.get(i)==nums.get(i-1)) i++; 
		 } while (i<nums.size()); 
		 return res; 
	 }
	 
	 public static void main(String[] args){
		 int[] nums = new int[]{2, 2, 4, 8}; 
		 P046_Permutations p = new P046_Permutations(); 
		 System.out.println(p.permuteUnique(nums)); 
	 }

}
