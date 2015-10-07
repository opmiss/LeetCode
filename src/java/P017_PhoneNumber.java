package java;
import java.util.*;

public class P017_PhoneNumber {
	Map<Character, ArrayList<String>> map; 
    public ArrayList<String> letterCombinations(String digits) {
        map = new HashMap<Character, ArrayList<String>>();
        ArrayList<String> one = new ArrayList<String>(); one.add(""); 
        ArrayList<String> two = new ArrayList<String>(); two.add("a"); two.add("b"); two.add("c");  
        ArrayList<String> three = new ArrayList<String>(); three.add("d"); three.add("e"); three.add("f");  
        ArrayList<String> four = new ArrayList<String>(); four.add("g"); four.add("h"); four.add("i");  
        ArrayList<String> five = new ArrayList<String>(); five.add("j"); five.add("k"); five.add("l");  
        ArrayList<String> six = new ArrayList<String>(); six.add("m"); six.add("n"); six.add("o");  
        ArrayList<String> seven = new ArrayList<String>(); seven.add("p"); seven.add("q"); seven.add("r"); seven.add("s"); 
        ArrayList<String> eight = new ArrayList<String>(); eight.add("t"); eight.add("u"); eight.add("v");
        ArrayList<String> nine = new ArrayList<String>(); nine.add("w"); nine.add("x"); nine.add("y"); nine.add("z"); 
        ArrayList<String> zero = new ArrayList<String>(); zero.add(""); 
        map.put('1', one); 
        map.put('2', two); 
        map.put('3', three); 
        map.put('4', four); 
        map.put('5', five); 
        map.put('6', six); 
        map.put('7', seven); 
        map.put('8', eight); 
        map.put('9', nine); 
        map.put('0', zero); 
        ArrayList<String> ret = new ArrayList<String>(); ret.add(""); 
        for (int i=0; i<digits.length(); i++){
            ret = cross(ret, map.get(digits.charAt(i))); 
        }
        return ret; 
    }
    public ArrayList<String> cross(ArrayList<String> list1, ArrayList<String> list2){
        ArrayList<String> ret = new ArrayList<String>(); 
       // if (list1.isEmpty()) return list2; 
        //if (list2.isEmpty()) return list1; 
        for (String s1:list1){
            for (String s2:list2){
                StringBuffer sb = new StringBuffer(); 
                sb.append(s1); sb.append(s2); 
                ret.add(sb.toString()); 
            }
        }
        return ret; 
    }

}
