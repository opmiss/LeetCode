package java;
import java.util.*;

/*
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * For example,
 * Given height = [2,1,5,6,2,3],
 * return 10.
 */ 

public class P084_LargestRectangle {
	public int largestRectangleArea(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();
		int maxArea = 0; 
		for (int i=0; i<=height.length; i++){
			int a = (i==height.length)?0:height[i]; 
			if (stack.isEmpty()||height[stack.peek()]<=a){
				stack.push(i); 
			}
			else {
				do {
					int top = height[stack.pop()];
					if (stack.isEmpty()) {
						maxArea = Math.max(top * i, maxArea);
					} else {
						maxArea = Math.max(top * (i - 1 - stack.peek()),
								maxArea);
					}
				} while (!stack.isEmpty()&&height[stack.peek()] > a);
				stack.push(i); 
			}
		}
		return maxArea; 
    }
	
	public static void main(String[] args){
		P084_LargestRectangle p = new P084_LargestRectangle(); 
		int[] h = new int[]{0, 3, 2, 5};
		System.out.println(p.largestRectangleArea(h)); 
	}

}
