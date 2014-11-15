package com.leetcode.problems.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/*
 * Given two words (start and end), and a dictionary, 
 * find all shortest transformation sequence(s) from start to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example, given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * Return:
 * [
 * 	["hit","hot","dot","dog","cog"],
 * 	["hit","hot","lot","log","cog"]
 * ]
 * */

public class WordLadder2 {
	static class Node {
		String word;
		ArrayList<Node> prev = new ArrayList<Node>();
		boolean[] fan;

		Node(String s) {
			word = s;
			fan = new boolean[s.length()];
			for (int i = 0; i < fan.length; i++)
				fan[i] = true; //can vary the character on pos i 
		}

		int compare(Node n) {
			int l = word.length();
			int diff = 0;
			for (int i = 0; i < l; i++) {
				if (word.charAt(i) != n.word.charAt(i))
					diff++;
			}
			return diff;
		}
	}
	
	public static LinkedList<Node> queue;
	public static HashMap<String, Node> map;
	public static HashSet<String> visited;
	public static HashMap<String, ArrayList<String>> index;
	public static int sol_length;

	public static HashMap<String, ArrayList<String>> buildIndex(
			HashSet<String> dict) {
		//build a index hashmap in which key is a regex, value is a list of words associated with this regex, 
		// ca? -> cat, cap, can 
		HashMap<String, ArrayList<String>> index = new HashMap<String, ArrayList<String>>();
		char[] arry;
		for (String s : dict) {
			arry = s.toCharArray();
			for (int i = 0; i < s.length(); i++) {
				arry[i] = '?';
				String id = String.valueOf(arry);
				ArrayList<String> list = index.get(id);
				if (null == list) {
					list = new ArrayList<String>();
				}
				list.add(s);
				index.put(id, list);
				arry[i] = s.charAt(i);
			}
		}
		return index;
	}

	
	public static ArrayList<ArrayList<String>> findPaths(Node node,
			ArrayList<String> path) {
		ArrayList<ArrayList<String>> paths = new ArrayList<ArrayList<String>>();
		if (node.prev.isEmpty()) {
			paths.add(path);
			return paths;
		}
		for (Node par : node.prev) {
			ArrayList<String> p = (ArrayList<String>) path.clone();
			p.add(par.word);
			paths.addAll(findPaths(par, p));
		}
		return paths;
	}

	public static ArrayList<ArrayList<String>> findPaths(Node node, String end) {
		ArrayList<String> path = new ArrayList<String>();
		path.add(end);
		path.add(node.word);
		ArrayList<ArrayList<String>> sols = findPaths(node, path);
		for (ArrayList<String> sol : sols) {
			Collections.reverse(sol);
		}
		return sols;
	}

	public static ArrayList<ArrayList<String>> findLadders(String start,
			String end, HashSet<String> dict) {
		dict.add(start);
		dict.add(end);
		index = buildIndex(dict);
		ArrayList<ArrayList<String>> ladders = new ArrayList<ArrayList<String>>();
		Node sn = new Node(start);
		Node en = new Node(end);
		if (sn.compare(en) == 1) {
			ArrayList<String> sol = new ArrayList<String>();
			sol.add(sn.word);
			sol.add(en.word);
			ladders.add(sol);
			return ladders;
		}
		//Breadth first search
		queue = new LinkedList<Node>();
		queue.add(sn);
		sol_length = Integer.MAX_VALUE;
		boolean goon = true;
		int leng = start.length();
		char[] nchar;
		String id;
		map = new HashMap<String, Node>();
		visited = new HashSet<String>(); // a set of visited string
		while (!queue.isEmpty()) {
			Node cur = queue.remove();
			visited.add(cur.word);
			nchar = cur.word.toCharArray();
			for (int i = 0; i < leng; i++) {
				if (cur.fan[i]) {
					nchar[i] = '?';
					id = String.valueOf(nchar);
					ArrayList<String> list = index.get(id);
					if (null != list) {
						for (String s : list) {
							if (s.equals(end)) {
								ArrayList<ArrayList<String>> sol = findPaths(
										cur, s);
								ladders.addAll(sol);
								map.clear();
								goon = false;
							} else if (goon) {
								if (!visited.contains(s)) {
									Node node = map.get(s);
									if (null == node) {
										node = new Node(s);
									}
									node.fan[i] = false;
									node.prev.add(cur);
									map.put(s, node);
								}
							}
						}
					}
					nchar[i] = cur.word.charAt(i);
				}
			}
			if (queue.isEmpty()) {
				if (map.isEmpty())
					break;
				queue.addAll(map.values());
				map.clear();
			}
		}
		return ladders;
	}

}
