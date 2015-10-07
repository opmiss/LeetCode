package java;

public class P011_Container {
	public int maxArea(int[] height) {
        if (height.length<2) return 0; 
        int start = 0; 
        int end = height.length-1; 
        int maxarea = Math.min(height[start], height[end])*(end-start); 
        while (start<end){
            if (height[start] < height[end]) start++; 
            else end--; 
            maxarea = Math.max(maxarea, Math.min(height[start], height[end])*(end-start)); 
        }
        return maxarea; 
    }
}
