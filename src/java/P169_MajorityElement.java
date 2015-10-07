package java;

public class P169_MajorityElement {
	public int majorityElement(int[] num) {
        int majorityIndex = 0;
        for (int count = 1, i = 1; i < num.length; i++) {
            if (num[majorityIndex] == num[i]) count++; 
            else count--;
            if (count == 0) {
                majorityIndex = i;
                count = 1;
            }
            
        }
        return num[majorityIndex];
    }
}
