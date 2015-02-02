package com.leetcode.problems.array;

public class Candy {
	/*
	 * There are N children standing in a line. Each child is assigned a rating value.
	 * You are giving candies to these children subjected to the following requirements:
	 * Each child must have at least one candy.
	 * Children with a higher rating get more candies than their neighbors.
	 * What is the minimum candies you must give?
	 */
    public int candy(int[] ratings) {
    	if (ratings.length < 2) return ratings.length;
    	int up=0, down=0, num=0, i=0; 
    	 while (i<ratings.length){
             if (i+1==ratings.length) return num+1; 
             while (i+1<ratings.length && ratings[i]==ratings[i+1]){num++; i++;}
             while (i+1<ratings.length && ratings[i]<ratings[i+1]){up++; i++;}
             while (i+1<ratings.length && ratings[i]>ratings[i+1]){down++; i++;}
             num+=calculate(up, down);
             up=0; down=0; 
         }
         return num; 
     }
     int calculate(int up, int down){
         if (up>down){
             return sum(up+1)+sum(down)-1; 
         }else{
             return sum(up)+sum(down+1)-1; 
         }
     }
     int sum(int n){
     	return (1+n)*n/2; 
     }
     
     public void test(){
    	 int[] num = new int[]{1, 3, 8, 4, 2, 1};
    	 System.out.println(candy(num)); 
     }

    public static void main(String[] args){
    	Candy c = new Candy(); 
    	c.test(); 
    }
}
