package Java;

import java.util.Stack;

public class P207_CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
    	Stack<Integer>[] P = new Stack[numCourses]; 
    	boolean[] V = new boolean[numCourses]; 
    	for (int i=0; i<numCourses; i++) P[i] = new Stack<Integer>(); 
    	int np = prerequisites.length; 
    	for (int i=0; i<np; i++){
    		P[prerequisites[i][0]].push(prerequisites[i][1]); 
    	}
    	for (int i=0; i<numCourses; i++){
    		boolean b = visit(i, P, V); 
    		if (!b) return false; 
    	}
    	return true; 
    }
    
    public boolean visit(Integer c, Stack<Integer>[] P, boolean[] V){
    	if (V[c]) return false; 
    	if (P[c].isEmpty()) return true; 
    	V[c]=true; 
    	while (!P[c].isEmpty()) {
    		boolean b = visit(P[c].pop(), P, V); 
    		if (!b) return false; 
    	}
    	V[c] = false; 
    	return true; 
    }

}
