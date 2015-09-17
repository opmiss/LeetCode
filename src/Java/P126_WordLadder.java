package Java;
import java.util.*;

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

public class P126_WordLadder {
	int wleng; 
	public Map<String, List<String>> buildIndex(Set<String> dict){
		Map<String, List<String>> res = new HashMap<String, List<String>>();
		for (String w:dict){
			StringBuilder sb = new StringBuilder(w);
			for (int i=0; i<wleng; i++){
				sb.setCharAt(i, '?');
				String key = sb.toString(); 
				if (res.get(key)==null) res.put(key, new ArrayList<String>()); 
				res.get(key).add(w);
				sb.setCharAt(i, w.charAt(i));
			}
		}
		return res; 
	}
	public int ladderLength(String start, String end, Set<String> dict) {
        wleng=start.length(); 
		Map<String, List<String>> map = buildIndex(dict);
		Set<String> visiting = new HashSet<String>(); 
		Set<String> visitnext = new HashSet<String>(); 
		Set<String> visited = new HashSet<String>(); 
		visiting.add(start); 
		int step=1; 
		do { 
			for (String w:visiting) {
				if (w.equals(end)) return step;
				visited.add(w);
				StringBuilder sb = new StringBuilder(w); 
				for (int i=0; i<wleng; i++){
					sb.setCharAt(i, '?');
					for (String nb:map.get(sb.toString())){
						if (visited.contains(nb)||visiting.contains(nb)) continue; 
						visitnext.add(nb); 
					}
					sb.setCharAt(i, w.charAt(i)); 
				}
			}
			step++;
			Set<String> temp = visiting; 
			visiting = visitnext; 
			visitnext = temp;
			visitnext.clear(); 
		} while (!visiting.isEmpty());
		return 0; 
    }
	class Node{
		String word; 
		ArrayList<Node> prev; 
		Node(String w){
			word =w; 
			prev = new ArrayList<Node>(); 
		}
		@Override
		public int hashCode(){
			return word.hashCode(); 
		}
	}
	List<List<String>> genPaths(Node node){
		List<List<String>> res = new ArrayList<List<String>>(); 
        if (node.prev.isEmpty()){
            List<String> list = new ArrayList<String>(); 
            list.add(node.word); 
            res.add(list); 
            return res; 
        } 
        for (Node prev:node.prev){
            List<List<String>> paths = genPaths(prev);
            for (List<String> path:paths){
                path.add(node.word); 
            }
            res.addAll(paths); 
        }
        return res; 
	}
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		wleng=start.length(); 
		Map<String, List<String>> map = buildIndex(dict);
		HashMap<String, Node> visiting = new HashMap<String, Node>(); 
		HashMap<String, Node> visitnext = new HashMap<String, Node>(); 
		Set<String> visited = new HashSet<String>(); 
		Node snode = new Node(start); 
		visiting.put(start, snode); 
		do { 
			for (String w:visiting.keySet()) {
				//System.out.println("visit: "+w); 
				if (w.equals(end)) return genPaths(visiting.get(w));
				visited.add(w);
				StringBuilder sb = new StringBuilder(w); 
				for (int i=0; i<wleng; i++){
					sb.setCharAt(i, '?');
					for (String nb:map.get(sb.toString())){
						if (visited.contains(nb)||visiting.containsKey(nb)) continue; 
						if (visitnext.get(nb)==null) visitnext.put(nb, new Node(nb));
						visitnext.get(nb).prev.add(visiting.get(w)); 
					}
					sb.setCharAt(i, w.charAt(i)); 
				}
			}
			HashMap<String, Node> temp = visiting; 
			visiting = visitnext;  
			visitnext = temp;
			visitnext.clear(); 
		} while (!visiting.isEmpty());
		return new ArrayList<List<String>>(); 
    }
	public static void main(String[] args){
		String start = "a"; 
		String end="c"; 
		Set<String> dict = new HashSet<String>(); 
		dict.add("a"); 
		dict.add("b");
		dict.add("c"); 
		P126_WordLadder p = new P126_WordLadder(); 
		System.out.println(p.findLadders(start, end, dict)); 
	}
}
