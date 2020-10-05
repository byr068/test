package com;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class temp {
    /**
     * 当总和小于0的时候，应该是记录一个重新开始的坐标，
     * 到总和大于原来的max的时候才能记录新的起点坐标。
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "ascd";
        //System.out.println(lengthOfLongestSubstring(s));

    }
   static int[] helper(int[][] arr){
        arr[0][0] = 1;
        arr[0][1] = 1;
        return arr[0];
   }
}
