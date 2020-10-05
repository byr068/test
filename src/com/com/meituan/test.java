package com.com.meituan;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class test {
    public static void main(String[] args) {
        solution1 s = new solution1();
        int[] arr = {1,2,3,4,5};
        System.out.println(s.minVal(arr));
    }
}
class solution1{
    public int minVal(int[] x){
        if(x==null||x.length==0)return 0;
        Arrays.sort(x);
        int count = 0;
        int minVal = Integer.MAX_VALUE;
        for(int temp : x){
            count += temp-x[0];
        }
        for(int i=1;i<x.length;i++){
            count = count + i*(x[i]-x[i-1])-(x.length-i)*(x[i]-x[i-1]);
            minVal = Math.min(minVal,count);
        }
        return minVal;
    }
}