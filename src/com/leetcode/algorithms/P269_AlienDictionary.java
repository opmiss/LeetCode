package com.leetcode.algorithms;
import java.util.*;

public class P269_AlienDictionary {
	/*
	 * given a list of words sorted lexicographically, find the order of characters 
	 * e.g. if the input is [ "wrt", "wrf", "er", "ett", "rftt" ] 
	 * The correct order is: "wertf"
	 */
	public class Vertex{
		public char ch; 
		public Set<Vertex> nb; 
		public int indegree=0; 
		public Vertex(char c){
			ch = c; 
			nb = new HashSet<Vertex>(); 
		}
		/*@Override
		public int hashCode(){
			return ch; 
		}*/
	}
	
	public String alienOrder(String[] words) {
		Map<Character, Vertex> graph = new HashMap<Character, Vertex>();
		Set<Vertex> set = new HashSet<Vertex>(); 
		for (int i=1;i<words.length; i++){
			for (int k=0; k<words[i].length(); k++){
				if (words[i].charAt(k)!=words[i-1].charAt(k)){
					Vertex from = graph.get(words[i-1].charAt(k));
					if (from==null){
						from = new Vertex(words[i-1].charAt(k)); 
						graph.put(words[i-1].charAt(k), from); 
					}
					Vertex to = graph.get(words[i].charAt(k));
					if (to==null){
						to = new Vertex(words[i].charAt(k)); 
						graph.put(words[i].charAt(k), to); 
					}
					if (from.nb.add(to)) to.indegree++; 
					if (from.indegree==0) set.add(from);
					set.remove(to); 
					break; 
				}
			}
		}
		return topologicalSort(set); 
	}
	public String topologicalSort(Set<Vertex> set){
		StringBuffer sb = new StringBuffer(); 
		Queue<Vertex> queue = new LinkedList<Vertex>(set); 
		while (!queue.isEmpty()){
			Vertex cur = queue.poll(); 
			sb.append(cur.ch); 
			for (Vertex v:cur.nb){
				if (--v.indegree==0) queue.add(v); 
			}
		}
		return sb.toString(); 
	}
	public static void main(String[] args){
		P269_AlienDictionary p = new P269_AlienDictionary(); 
		String[] input = new String[]{"dance", "dump", "elephant", "fun","girl", "henry", "ice","jack","jar",
				"king","laura","marry","nancy","null","opera","piggy","queen", "ray","sand", "tom","tracy", "uber",
				"umbrella", "vivian","will","xman","york", "zebra", "zoo"}; 
		System.out.println(p.alienOrder(input)); 
	}
}
