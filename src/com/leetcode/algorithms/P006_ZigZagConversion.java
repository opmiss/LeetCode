package com.leetcode.algorithms;

public class P006_ZigZagConversion {
	public String convert(String s, int nRows) {
        if (s.length()<3) return s; 
        if (nRows <2) return s; 
        StringBuffer[] row = new StringBuffer[nRows]; 
        int i=0; 
        int k=0; 
        boolean down = true; 
        while (i<s.length()){
          if (row[k]==null) row[k] = new StringBuffer();  
          row[k].append(s.charAt(i)); 
          i++; 
          if (down) {
              k++;
              if (k>nRows-1) {
                  down = false; 
                  k = nRows-2; 
              }
          }
          else {
              k--; 
              if (k<0) {
                  down = true;
                  k=1; 
              }
          }
        }
        k = 1; 
        while (k<nRows){
            if (row[k]!=null) {
                row[0].append(row[k]);
                k++; 
            }
            else break; 
        }
        return row[0].toString(); 
    }
}
